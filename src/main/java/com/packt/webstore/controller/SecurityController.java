package com.packt.webstore.controller;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.exception.EmailExistsException;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class SecurityController {

    private CustomerService customerService;

    private UserDetailsService userDetailsService;

    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Autowired
    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        session.setAttribute("email",email);
        return "login";
    }
    @RequestMapping(value="/loginfailed", method =
            RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {

        return "login";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignIn(Model model){

        model.addAttribute("newCustomer", new Customer());
        return "signIn";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("newCustomer") @Valid Customer customer,
                         BindingResult result, HttpServletRequest request){

        if(!customerService.emailAvailable(customer.getEmail())){
            result.addError(new ObjectError("emailUnavailable","This e-mail is already in use"));
        }
        if(result.hasErrors()|| createCustomerAccount(customer)==null) {
            return "signIn";
        }


        autoLogin(customer.getEmail(),customer.getPassword(),request);

        return "redirect:/";
    }




    private boolean autoLogin( String username, String password, HttpServletRequest request) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication );

        //this step is important, otherwise the new login is not in session which is required by Spring Security
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());


        return true;
    }

    private Customer createCustomerAccount(Customer customer){
        try {
            customerService.addCustomer(customer);
        }
        catch(EmailExistsException ex){
            return null;
        }
        return customer;
    }
}

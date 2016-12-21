package com.packt.webstore.controller;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class SecurityController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); //get logged in username
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
    public String signIn(@ModelAttribute("newCustomer") Customer customer){

        customerService.addCustomer(customer);
        return "redirect:/home"; //TODO improve sign in mechanism (redirect to previous page)
    }

}

package com.packt.webstore.controller;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.exception.EmailExistsException;
import com.packt.webstore.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CustomerController {


    private CustomerService customerService;

    protected static Logger logger = Logger.getLogger("Customer_controller");

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customers(Model model){

        logger.debug("Received request to show all customers");

        model.addAttribute("customers",customerService.getAllCustomers());
        return "customers";
    }
    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String getAddCustomer(Model model){

        logger.debug("Received request to show add customer page");

        model.addAttribute("newCustomer", new Customer());

        return "signIn";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("newCustomer") @Valid Customer customer,
                              BindingResult result){

        logger.debug("Received request to add new customer");
        if(result.hasErrors() || createCustomerAccount(customer)==null) {
            return "signIn";
        }

        return "redirect:/";
    }


    @RequestMapping(value = "/customers/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id, Model model){

        logger.debug("Received request to delete existing customer");

        customerService.deleteCustomer(id);

        model.addAttribute("id", id);

        return "redirect:/customers";
    }

    @RequestMapping(value = "/customers/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id") Integer id, Model model){

        logger.debug("Received request to show edit page");

        model.addAttribute("customer", customerService.getCustomerById(id));

        return "editCustomerInfo";
    }

    @RequestMapping(value = "/customers/edit", method = RequestMethod.POST)
    public String saveEditions(@ModelAttribute("customer") Customer customer,
                               @RequestParam(value = "id") Integer id, Model model){

        logger.debug("Received request to update person");

        customer.setCustomerId(id);

        customerService.editCustomerInfo(customer);

        model.addAttribute("id", id);

        return "redirect:/customers";
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

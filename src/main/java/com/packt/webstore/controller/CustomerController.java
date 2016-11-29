package com.packt.webstore.controller;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    protected static Logger logger = Logger.getLogger("Customer_controller");

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
    public String addCustomer(@ModelAttribute("newCustomer") Customer customer){

        logger.debug("Received request to add new customer");

        customerService.addCustomer(customer);

        return "redirect:/customers";
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

        model.addAttribute("customer", customerService.getCustomer(id));

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

}

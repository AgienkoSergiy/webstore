package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.exception.EmailExistsException;
import com.packt.webstore.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger("Customer_service");

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        logger.debug("Retrieving all customers");
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        logger.debug("Retrieving customer with id="+id);
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        logger.debug("Retrieving customer with email "+email);
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public Customer getCurrentCustomer() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof String){
            return null;
        }
        return getCustomerByEmail(((User)principal).getUsername());
    }

    @Override
    public void addCustomer(Customer customer) throws EmailExistsException {
        logger.debug("Adding new customer");
        if(!customerRepository.emailAvailable(customer.getEmail())){
            throw new EmailExistsException();
        }
        customerRepository.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id){

        logger.debug("Deleting existing customer");
        customerRepository.deleteCustomer(id);
    }

    @Override
    public void editCustomerInfo(Customer customer){

        logger.debug("Editing existing customer");
        customerRepository.editCustomerInfo(customer);
    }

    @Override
    public Boolean emailAvailable(String email) {
        return customerRepository.emailAvailable(email);
    }

    @Override
    public Boolean customerExists(String email) {

        return customerRepository.customerExists(email);
    }
}

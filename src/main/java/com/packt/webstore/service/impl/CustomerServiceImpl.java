package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    protected static Logger logger = Logger.getLogger("Customer_service");

    @Autowired
    private CustomerRepository customerRepository;

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
    public void addCustomer(Customer customer) {

        logger.debug("Adding new customer");
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

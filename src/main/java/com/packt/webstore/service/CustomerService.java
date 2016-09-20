package com.packt.webstore.service;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(String customerId);

    public Boolean isCustomerExist(String customerId);
}

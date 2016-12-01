package com.packt.webstore.service;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    Customer getCustomerByEmail(String email);

    void deleteCustomer(Integer id);

    Boolean customerExists(String email);

    void editCustomerInfo(Customer customer);

    Boolean emailAvailable(String email);
}

package com.packt.webstore.service;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(Integer id);

    void deleteCustomer(Integer id);

    Boolean customerExists(Integer id);

    void editCustomerInfo(Customer customer);
}

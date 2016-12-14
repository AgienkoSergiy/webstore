package com.packt.webstore.domain.repository;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer customerId);

    Customer getCustomerByEmail(String email);

    Boolean customerExists(String email);

    Boolean emailAvailable(String email);

    void addCustomer(Customer customer);

    void deleteCustomer(Integer id);

    void editCustomerInfo(Customer customer);
}

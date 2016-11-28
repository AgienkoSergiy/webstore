package com.packt.webstore.domain.repository;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(String customerId);

    Boolean isCustomerExist(String customerId);
}

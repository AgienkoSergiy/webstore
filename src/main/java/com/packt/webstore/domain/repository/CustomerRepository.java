package com.packt.webstore.domain.repository;


import com.packt.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();

    Customer getCustomer(Integer customerId);

    Boolean customerExists(Integer customerId);

    public void addCustomer(Customer customer);

    public void deleteCustomer(Integer id);

    public void editCustomerInfo(Customer customer);
}

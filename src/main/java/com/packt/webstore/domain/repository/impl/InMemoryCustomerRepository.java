package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {


    List<Customer> customersList = new ArrayList<Customer>();

    public InMemoryCustomerRepository(){

        Customer misha = new Customer("C0001","Misha","Helsinki");
        Customer vasya = new Customer("C0002", "Vasya", "Mena");
        Customer kolya = new Customer("C0003", "Kolya", "Altep");

        customersList.add(misha);
        customersList.add(vasya);
        customersList.add(kolya);
    }

    public List<Customer> getAllCustomers() {
        return customersList;
    }
}

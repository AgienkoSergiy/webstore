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

        Customer misha = new Customer(1,"Misha");
        Customer vasya = new Customer(2, "Vasya");
        Customer kolya = new Customer(3, "Kolya");

        customersList.add(misha);
        customersList.add(vasya);
        customersList.add(kolya);
    }

    public List<Customer> getAllCustomers() {
        return customersList;
    }

    @Override
    public void saveCustomer(Customer customer) {
        for (Customer user :
                customersList) {
            if (user.getCustomerId().equals(customer.getCustomerId())){
                customersList.set(customersList.indexOf(user),customer);
                System.out.println(customersList.get(customersList.indexOf(user)));
                return;
            }
        }
        customersList.add(customer);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        for (Customer customer:
             customersList) {
            if(customer.getCustomerId().equals(customerId))
                return customer;
        }
        return null;
    }

    @Override
    public Boolean isCustomerExist(Integer customerId) {

        for (Customer customer :
                customersList) {
         if(customer.getCustomerId().equals(customerId))
             return true;
        }
        return false;
    }
}

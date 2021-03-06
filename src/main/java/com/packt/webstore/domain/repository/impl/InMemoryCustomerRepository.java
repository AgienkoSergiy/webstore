package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class InMemoryCustomerRepository {


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

    public Customer getCustomer(Integer customerId) {
        for (Customer customer:
             customersList) {
            if(customer.getCustomerId().equals(customerId))
                return customer;
        }
        return null;
    }

    public Boolean customerExists(Integer customerId) {

        for (Customer customer :
                customersList) {
         if(customer.getCustomerId().equals(customerId))
             return true;
        }
        return false;
    }

    public void addCustomer(Customer customer) {

    }

    public void deleteCustomer(Integer id) {

    }

    public void editCustomerInfo(Customer customer) {

    }
}

package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MySQLCustomerRepository implements CustomerRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAllCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Customer");
        return query.list();
    }

    @Override
    public Customer getCustomer(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        return (Customer)session.get(Customer.class,id);
    }

    @Override
    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id){

        Session session = sessionFactory.getCurrentSession();

        Customer customer = (Customer)session.get(Customer.class,id);
        session.delete(customer);
    }

    @Override
    public void editCustomerInfo(Customer customer){

        Session session = sessionFactory.getCurrentSession();

        Customer existingCustomer =
                (Customer)session.get(Customer.class,customer.getCustomerId());

        existingCustomer.setName(customer.getName());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setBillingAddress(customer.getBillingAddress());
        existingCustomer.setEmail(customer.getEmail());

        session.save(existingCustomer);
    }

    @Override
    public Boolean customerExists(Integer id) {

        return getCustomer(id)!=null;
    }
}

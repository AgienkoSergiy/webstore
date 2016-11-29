package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    protected static Logger logger = Logger.getLogger("Customer_service");


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAllCustomers() {

        logger.debug("Retrieving all customers");

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

        logger.debug("Adding new customer");

        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id){

        logger.debug("Deleting existing customer");

        Session session = sessionFactory.getCurrentSession();

        Customer customer = (Customer)session.get(Customer.class,id);
        session.delete(customer);
    }

    @Override
    public void editCustomerInfo(Customer customer){

        logger.debug("Editing existing customer");

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
    public Boolean isCustomerExist(Integer id) {

        return getCustomer(id)!=null;
    }
}

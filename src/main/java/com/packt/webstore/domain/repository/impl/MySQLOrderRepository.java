package com.packt.webstore.domain.repository.impl;



import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;


@Repository
public class MySQLOrderRepository implements OrderRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Long saveOrder(Order order) {
        order.setOderDate(new Date());
        create(order);

        return order.getOrderId();
    }

    @Override
    public Order create(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
        return order;
    }

    @Override
    public Order read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Order where id = :id");
        query.setParameter("id", id);
        if (query.list().isEmpty()){
            return null;
        }
        return (Order) query.list().get(0);
    }

    @Override
    public void update(Long id, Order order) {
        Order existingOrder = read(id);
        if(existingOrder==null){
            throw new IllegalArgumentException("Can not read a cart." +
                    " A cart with the given id" + id +" does not exist");
        }
        Session session = sessionFactory.getCurrentSession();
        existingOrder.setCart(order.getCart());
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setDeliveryInfo(order.getDeliveryInfo());
        existingOrder.setOderDate(order.getOderDate());
        session.merge(existingOrder);
    }

    @Override
    public void delete(Long id) {

        Order cart = read(id);
        if(cart==null){
            throw new IllegalArgumentException("Can not read a cart." +
                    " A cart with the given id" + id +" does not exist");
        }
        Session session = sessionFactory.getCurrentSession();
        session.delete(cart);
    }
}

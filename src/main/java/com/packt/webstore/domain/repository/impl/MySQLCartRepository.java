package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class MySQLCartRepository implements CartRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Cart create(Cart cart) {

        if(cartExists(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Can not create a cart." +
                    " A cart with the given id (%) already exists",cart.
                    getCartId()));
        }
        Session session = sessionFactory.getCurrentSession();
        session.save(cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where id = :id");
        query.setParameter("id", cartId);
        if (query.list().isEmpty()){
            return null;
        }
        return (Cart) query.list().get(0);
    }

    @Override
    public void update(String cartId,  Cart cart) {

        Cart existingCart = read(cartId);
        if(existingCart==null){
            throw new IllegalArgumentException("Can not read a cart." +
                    " A cart with the given id" + cartId +" does not exist");
        }
        Session session = sessionFactory.getCurrentSession();
        existingCart.setCartItems(cart.getCartItems());
        existingCart.updateGrandTotal();
        session.merge(existingCart);
       // session.save(existingCart);
    }

    @Override
    public void delete(String cartId) {

        Cart cart = read(cartId);
        if(cart==null){
            throw new IllegalArgumentException("Can not read a cart." +
                    " A cart with the given id" + cartId +" does not exist");
        }
        Session session = sessionFactory.getCurrentSession();
        session.delete(cart);
    }

    private Boolean cartExists(String cartId){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where id = :id");
        query.setParameter("id", cartId);
        return !query.list().isEmpty();
    }

}

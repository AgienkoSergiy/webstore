package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.repository.CartItemRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO make repositories methods processing and names similar!!!
@Repository
public class MySQLCartItemRepository implements CartItemRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public CartItem create(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cartItem);
        return cartItem;
    }

    @Override
    public CartItem read(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        return (CartItem)session.get(CartItem.class,id);
    }

    @Override
    public void update(CartItem cartItem) {

        CartItem existingCartItem = read(cartItem.getId());
        Session session = sessionFactory.getCurrentSession();
        existingCartItem.setProduct(cartItem.getProduct());
        existingCartItem.setQuantity(cartItem.getQuantity());
        existingCartItem.updateTotalPrice();
        existingCartItem.setCart(cartItem.getCart());
        session.save(existingCartItem);
    }

    @Override
    public void delete(Integer id) {

        CartItem cartItem = read(id);
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
    }

    @Override
    public Map<Integer, CartItem> getCartItems(String cartId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cart.id = :id order by id");
        query.setParameter("id", cartId);
        List<CartItem> queryList = query.list();
        if (queryList.isEmpty()){
            return null;
        }
        Map<Integer, CartItem> result = new HashMap<>();
        int i =1;
        for(CartItem item:queryList){
            result.put(i,item);
            i++;
        }
        return result;
    }
}

package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.repository.CartItemsRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MySQLCartItemsRepository implements CartItemsRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public Map<Integer, CartItem> create(Cart cart) {
        return new HashMap<>(); //TODO what is this?
    }

    @Override
    public Map<Integer, CartItem> read(String cartId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cart.id = :id order by id");
        query.setParameter("id", cartId);
        if (query.list().isEmpty()){
            return new HashMap<>();
        }
        //TODO make it right:
        List<CartItem> cartItems = new ArrayList<>(query.list());
        Map<Integer, CartItem> result = new HashMap<>();

        for (int i = 0; i < cartItems.size(); i++) {
            result.put((i+1),cartItems.get(i));
            System.out.println(i+"  _+_+_+_+_+_+_+_");
        }
        return result;
    }

    @Override
    public void update(String cartId, Cart cart) {

        Map<Integer,CartItem> existingCartItems = read(cartId);
        Session session = sessionFactory.getCurrentSession();
        if(existingCartItems.size()==0){
            for(CartItem item:cart.getCartItems().values()){
                session.save(item);
                System.out.println("Item #"+item.getId() + " saved");
            }
        }


    }

    @Override
    public void delete(String cartId) {

    }
}

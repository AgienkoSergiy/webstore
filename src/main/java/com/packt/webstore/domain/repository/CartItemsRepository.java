package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;

import java.util.Map;


public interface CartItemsRepository {
    Map<Integer, CartItem> create(Cart cart);
    Map<Integer, CartItem> read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

}

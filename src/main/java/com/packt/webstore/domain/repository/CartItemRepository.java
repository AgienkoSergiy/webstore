package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;

import java.util.Map;


public interface CartItemRepository {
    CartItem create(CartItem cartItem);
    CartItem read(Integer id);
    void update(CartItem cartItem);
    void delete(Integer id);
    Map<Integer, CartItem> getCartItems(String cartId);

}

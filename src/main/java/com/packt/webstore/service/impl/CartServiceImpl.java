package com.packt.webstore.service.impl;


import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartItemRepository;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.exception.InvalidCartException;
import com.packt.webstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;  //TODO test&remake cart operations in private cabinet (Sprint#3)

    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }
    public Cart read(String cartId) {

        Cart cart = cartRepository.read(cartId);
        return cart;
    }
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
    public void delete(String cartId) {
        cartRepository.delete(cartId);

    }

    public Cart validate(String cartId) {
        Cart cart = read(cartId);
        if(cart==null || cart.getCartItems().size()==0) {
            throw new InvalidCartException(cartId);
        }

        return cart;
    }
}

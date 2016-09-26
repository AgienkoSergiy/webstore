package com.packt.webstore.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

    private Cart cart;

    @Before
    public void setup(){
        cart = new Cart();
    }

    @Test
    public void grand_total_verifying(){

        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
        Product laptop = new Product("P1235","laptop", new BigDecimal(700));

        CartItem cartItem1 = new CartItem(iphone);
        cart.addCartItem(cartItem1);

        CartItem cartItem2 = new CartItem(laptop);
        cart.addCartItem(cartItem2);


        BigDecimal totalCartPrice = iphone.getUnitPrice().multiply(new BigDecimal(cartItem1.getQuantity())).
                add(laptop.getUnitPrice().multiply(new BigDecimal(cartItem2.getQuantity())));

        Assert.assertEquals(totalCartPrice,cart.getGrandTotal());


    }
}

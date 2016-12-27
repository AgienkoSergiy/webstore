package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.OrderRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;


    public void processOrder(Integer productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
        productRepository.updateUnitsInStock(productById);
    }

    public void processOrder(Order order) {

        for(Product product:order.getCart().getCartItems()) // TODO continue here 27.12.2016
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
        productRepository.updateUnitsInStock(productById);
    }

    public Long saveOrder(Order order) {


        Long orderId = orderRepository.saveOrder(order);
        return orderId;
    }

}

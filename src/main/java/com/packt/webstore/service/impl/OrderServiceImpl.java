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

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }


    public void processOrder(Integer productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
        productRepository.updateUnitsInStock(productById);
    }

    public Long processOrder(Order order) { //TODO check capability to buy during adding product to cart action

        for(Product product:order.getCart().getCartItems().keySet()) {

            Product productById = productRepository.getProductById(product.getProductId());
            Integer quantity = order.getCart().getCartItems().get(productById).getQuantity();

            if(productById.getUnitsInStock() < quantity){
                throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
            }

            productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
            productRepository.updateUnitsInStock(productById);
        }
        return saveOrder(order);
    }

    public Long saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }

}

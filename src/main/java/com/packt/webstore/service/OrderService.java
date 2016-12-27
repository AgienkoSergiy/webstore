package com.packt.webstore.service;

import com.packt.webstore.domain.Order;

public interface OrderService {

    Long processOrder(Order order);

    Long saveOrder(Order order);
}

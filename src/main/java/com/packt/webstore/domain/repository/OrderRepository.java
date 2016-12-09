package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order); //TODO update or create?
	Order create(Order cart);
	Order read(Long id);
	void update(Long id, Order order);
	void delete(Long id);
}

package com.packt.webstore.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ORDER")
public class Order  implements Serializable{

	@Transient
	private static final long serialVersionUID = -3560539622417210365L;

	@Id
	@Column(name = "ID")
	private Long orderId;
	@OneToOne
	@Column(name = "ITEMS")
	private Cart cart;
	@OneToOne
	@Column(name = "USER")
	private Customer customer;
	@OneToOne
	@Column(name = "DELIVERY_INFO")
	private DeliveryInfo deliveryInfo;
	
	public Order() {
		this.customer = new Customer();
		this.deliveryInfo = new DeliveryInfo();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 829;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}


}

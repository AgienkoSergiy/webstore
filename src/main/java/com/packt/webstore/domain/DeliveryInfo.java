package com.packt.webstore.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY_INFO")
public class DeliveryInfo implements Serializable{

	private static final long serialVersionUID = 6350930334140807514L;

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
    @Column(name = "DELIVERY_DATE")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date deliveryDate;
    @Embedded
	private Address deliveryAddress;
	
	
		public DeliveryInfo() {
		this.deliveryAddress = new Address();
	}


	public Date getDeliveryDate() {
			return deliveryDate;
		}


	public void setDeliveryDate(Date shippingDate) {
		this.deliveryDate = shippingDate;
	}


	public Address getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(Address shippingAddress) {
		this.deliveryAddress = shippingAddress;
	}

	public Long getId() {
		return id;
	}

	public static long getSerialversionuid() {
			return serialVersionUID;
		}

}

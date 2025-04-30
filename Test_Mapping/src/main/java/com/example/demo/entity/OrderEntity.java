package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {  
	
	@Id
	@Column(name = "order_id")
	private int orderId;  
	
	@Column(name = "order_number")
	private double orderNumber;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  // Added cascade for proper relationship handling
	private PersonEntity personEntity;  // Changed field name to camelCase

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(double orderNumber) {
		this.orderNumber = orderNumber;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}
}
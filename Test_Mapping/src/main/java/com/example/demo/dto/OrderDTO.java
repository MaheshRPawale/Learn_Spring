package com.example.demo.dto;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class OrderDTO {
    private int orderId;
    private double orderNumber;
    
    PersonDto personDto;
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
}
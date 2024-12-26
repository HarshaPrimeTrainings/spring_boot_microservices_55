package com.training.springcoredemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Order {
	
	private int oid;
	private String ordername;
	private String status;
	private double price;
	
	@Qualifier("prime")
	@Autowired
	private Discount discount;
	
	public double getPrice() {
		return discount.getDiscount(price);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordername=" + ordername + ", status=" + status + ", price=" + price + "]";
	}
	
	
	
	

}

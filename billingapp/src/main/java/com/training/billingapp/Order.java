package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private List<Item> items;
	private Integer billAmount;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Integer getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}
	
	
}

package com.training.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.training.springcoredemo.services.Order;


@Component
public class User {

	private int uid;
	private String name;
	private String addrerss;
	
	// Feild level Injection
	private Order order;
	
	public User() {
		
	}
	

	
	public Order getOrder() {
		return order;
	}
	
	//Setter Injection
	@Autowired
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrerss() {
		return addrerss;
	}
	public void setAddrerss(String addrerss) {
		this.addrerss = addrerss;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", addrerss=" + addrerss + ", order=" + order + "]";
	}
	
	
	
}

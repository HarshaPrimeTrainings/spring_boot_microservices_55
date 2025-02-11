package com.training.userservice.dto;

import java.util.List;

import com.training.userservice.dao.Adress;

public class UserDto {
	
	private Integer uid;
	private String name;
	private String email;
	private Adress address;
	
	public Adress getAddress() {
		return address;
	}
	public void setAddress(Adress address) {
		this.address = address;
	}
	private List<Orders> orders;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}

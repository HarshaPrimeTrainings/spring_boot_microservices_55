package com.training.productapp.controller;

public class Product {

	private int pid;
	private String pname;
	private int quatity;
	
	public Product(int pid, String pname, int quatity) {
		this.pid = pid;
		this.pname = pname;
		this.quatity = quatity;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	
	
	
	
}

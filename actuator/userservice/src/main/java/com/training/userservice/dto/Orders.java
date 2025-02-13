package com.training.userservice.dto;

public class Orders {

	private Integer oid;
	private String catagoery;
	private Integer quantity;
	private String status;
	private Integer uid;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getCatagoery() {
		return catagoery;
	}
	public void setCatagoery(String catagoery) {
		this.catagoery = catagoery;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

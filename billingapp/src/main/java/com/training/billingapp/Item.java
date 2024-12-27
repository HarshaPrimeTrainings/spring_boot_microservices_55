package com.training.billingapp;

public class Item {
	
	private Integer itemId;
	private String itemName;
	private Integer itemPrice;
	
	public Item(Integer itemId, String itemName, Integer itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "["+itemId +"] " + itemName + " :: " + itemPrice;
	}
	
	

}

package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("bevragers")
public class Beverages implements Catogery{
	
	@Override
	public List<Item> getCatogery() {
		return List.of(new Item(10, "TEA", 20), new Item(11, "COFFE", 40),
				new Item(12, "MILK", 30));
	}

}

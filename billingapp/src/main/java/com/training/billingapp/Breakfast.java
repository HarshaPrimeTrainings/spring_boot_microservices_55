package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;


@Component("breakfast")
public class Breakfast implements Catogery{

	@Override
	public List<Item> getCatogery() {
		return List.of(new Item(1, "IDLI", 35), new Item(2, "POOHA", 45),
				new Item(3, "DOSA", 50),new Item(4, "WADA", 70),new Item(5, "POORI", 15));
	}

	
}

package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("lunch")
public class Lunch implements Catogery{
	
	@Override
	public List<Item> getCatogery() {
		return List.of(new Item(6, "S.MEAL", 50), new Item(7, "F.MEAL", 100),
				new Item(8, "CURD_RICE", 30),new Item(9, "COMBO", 90));
	}

}

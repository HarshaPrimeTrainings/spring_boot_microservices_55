package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChoiceService {
	
	public Item selectItem(List<Item> items,Integer itemId) {
		return items.stream().filter(item->item.getItemId() == itemId).findFirst().orElse(null);
	}
	

}

package com.training.billingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	
	@Autowired
	ChoiceService chioseService;
	
	
	@Qualifier("breakfast")
	@Autowired
	Catogery brakfast;
	
	@Qualifier("lunch")
	@Autowired
	Catogery lunch;
	
	@Qualifier("bevragers")
	@Autowired
	Catogery bevragers;
	
	@Autowired
	Order order;

	
	public Item placeOrder() {
		
		System.out.println("[1] BREAKFAST");
		System.out.println("[2] LUNCH");
		System.out.println("[3] BEVERAGES");
		
		Scanner sc = new Scanner(System.in);
		Integer catagoeryId= sc.nextInt();
		
		switch (catagoeryId) {
		case 1: {
			System.out.println("**** CHOOSE BREAKFAST ****");
			List<Item> breakFastList= brakfast.getCatogery();
			breakFastList.forEach(System.out::println);
			Integer itemId = sc.nextInt();
			Item item = chioseService.selectItem(breakFastList, itemId);
			if(item!=null) {
				return item;
			}else {
			System.out.println("Item Not Avilable");
			}
			break;
		}
		case 2: {
			System.out.println("**** CHOOSE LUNCH ****");
			List<Item> lunchList= lunch.getCatogery();
			lunchList.forEach(System.out::println);
			Integer itemId = sc.nextInt();
			Item item = chioseService.selectItem(lunchList, itemId);
			if(item!=null) {
				return item;
			}else {
			System.out.println("Item Not Avilable");
			}
			break;
		}
		case 3: {
			System.out.println("**** CHOOSE BEVERAGES ****");
			List<Item> bevragersList= bevragers.getCatogery();
			bevragersList.forEach(System.out::println);
			Integer itemId = sc.nextInt();
			Item item = chioseService.selectItem(bevragersList, itemId);
			if(item!=null) {
				return item;
			}else {
			System.out.println("Item Not Avilable");
			}
			break;
		}
		default:
			System.out.println("CHOOSE CORRECT SELECTION");
		}
		return null;
	}
	
	public Order claculatBill(List<Item> items) {
		Order order = new Order();
        order.setItems(items);
        int billAmount = items.stream()
                              .mapToInt(Item::getItemPrice)
                              .sum();
        order.setBillAmount(billAmount);
        return order;
	}

}

package com.training.billingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BillingappApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(BillingappApplication.class, args);
		OrderService orderSevice = ioc.getBean(OrderService.class);
		
		List<Item> orderlist = new ArrayList<>();
		boolean isBilled= false;
		
		System.out.println(" *** Welcome to RESTURANT ***** ");
		while(!isBilled) {
			Item item = orderSevice.placeOrder();
			orderlist.add(item);
			System.out.println("**** SELECTED ITEMS ****");
			orderlist.forEach(System.out::println);
			System.out.println("[Y] Confirm Order (or) [A] AddMore");
			Scanner sc = new Scanner(System.in);
			switch (sc.next().toUpperCase()) {
			case "Y": {
				Order order = orderSevice.claculatBill(orderlist);
				System.out.println(" *** BILL AMOUNT *** ");
				orderlist.forEach(x->System.out.println(x.getItemName()+ " :      " + x.getItemPrice()));
				System.out.println("----------------- ");
				System.out.println("BILL ::      "+order.getBillAmount());
				isBilled = true;
				break;
				}
			}
		}
		
	}

}

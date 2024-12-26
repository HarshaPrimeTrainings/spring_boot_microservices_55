package com.training.springcoredemo.services;

import org.springframework.stereotype.Component;

@Component("prime")
public class PrimeDiscountImpl implements Discount{
	
	@Override
	public Double getDiscount(double price) {	
		System.out.println("Prime Discount 20%");
		return price-(price*20.0/100.0);
	}

}

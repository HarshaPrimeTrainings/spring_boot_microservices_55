package com.training.springcoredemo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component()
public class DiscountImpl implements Discount{

	@Override
	public Double getDiscount(double price) {	
		System.out.println("Regular Discount 10%");
		return price-(price*10.0/100.0);
	}

}

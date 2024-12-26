package com.training.springcoredemo.services;

import org.springframework.stereotype.Component;

@Component
public interface Discount {

	public Double getDiscount(double price);
}

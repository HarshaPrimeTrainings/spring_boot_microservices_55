package com.training.billingapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Catogery {

	public List<Item> getCatogery();
}

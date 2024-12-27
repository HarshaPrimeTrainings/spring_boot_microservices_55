package com.training.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoA {
	
	@Autowired
	DemoB demob;

}

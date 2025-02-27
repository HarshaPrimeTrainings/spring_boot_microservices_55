package com.training.springdockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String greet() {
		return "<h1>Hello there Docker App Running</h1>";
	}
	
}

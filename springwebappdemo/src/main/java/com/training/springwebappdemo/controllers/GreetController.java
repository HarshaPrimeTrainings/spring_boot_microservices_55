package com.training.springwebappdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetController {
	

	@RequestMapping("/greet")
	public String greetAll() {
		return "greet";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}

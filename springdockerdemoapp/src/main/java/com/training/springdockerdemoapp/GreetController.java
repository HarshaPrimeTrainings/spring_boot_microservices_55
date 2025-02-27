package com.training.springdockerdemoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/secondapp")
	public String greet() {
		return "<h1>Second Docker Application Running</h1>";
	}
}

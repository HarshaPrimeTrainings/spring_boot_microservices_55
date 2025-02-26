package com.training.springkeycloak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/helloadmin")
	public String greet() {
		return "Hello There Iam Admin";
	}
	
	@GetMapping("/hellouser")
	public String greetuser() {
		return "Hello There Iam User";
	}
	
}

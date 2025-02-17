package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Orders;
import com.training.orderservice.dao.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository repo;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello From OrderService Instance2";
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return (List<Orders>) repo.findAll();
	}
	
	@PostMapping("/order")
	public Orders saveOrder(@RequestBody Orders o) {
		return repo.save(o);
	}
	
	@GetMapping("/order/{oid}")
	public Orders getOrderById(@PathVariable Integer oid) {
		return repo.findById(oid).orElse(null);
	}
	
	@GetMapping("/uidorders/{uid}")
	public List<Orders> getOrdersByUid(@PathVariable Integer uid){
		System.out.println("============= USERSERVICE ORDER =============");
		return repo.findByuid(uid);
	}
	
	
	
	
	
	
	
	
	
}

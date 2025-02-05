package com.training.userservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.Adress;
import com.training.userservice.dao.User;
import com.training.userservice.service.UserManagmentService;

@RestController
public class UserController {

	
	@Autowired
	UserManagmentService service;
	
	
	@GetMapping("/sortedusers/{column}/{sortOrder}")
	public List<User> getSortedUsers(@PathVariable String column,@PathVariable String sortOrder){
		return service.getSortedUsers(column,sortOrder);
	}
	
	
	@GetMapping("/userpage/{pageSize}/{pageNumber}")
	public List<User> getUserBypage(@PathVariable int pageNumber,@PathVariable int pageSize){
		return service.getUserByPage(pageNumber, pageSize);
	}
	
	
	@GetMapping("/addr/{zip}")
	public Adress geaddrByZip(@PathVariable Integer zip) {
		return service.getByZip(zip);
	}
	
	@GetMapping("/emailproc/{name}/{address}")
	public List<User> emialProc(@PathVariable String name,@PathVariable String address) {
		return service.execEmailProc(name,address);
	}
	
	
	@GetMapping("/procedure")
	public List<User> execProc() {
		return service.execProc();
	}
	
	
	@GetMapping("/useremail/{email}")
	public User getUserByEMail(@PathVariable String email) {
		return service.getUserByEmail(email);
	}
	
	
	
	@GetMapping("/username/{name}")
	public User getUserByName(@PathVariable String name) {
		return service.getUserByname(name);
	}
	
	@PostMapping(value = "/greet",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.TEXT_PLAIN_VALUE)
	public String greet(@RequestBody String msg) {
		return "<h1> Hello There!! </h1>"+msg;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("msg", "hello");
		httpHeaders.add("usercount",service.getAllUsers().size()+"");
		return new ResponseEntity<List<User>>(service.getAllUsers(),httpHeaders,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("msg", "hello");
		return new ResponseEntity<User>(service.getUserById(id),httpHeaders,HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> getUserByIdRequestparam(@RequestParam int id) {
		return new ResponseEntity<User>(service.getUserById(id),HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.saveUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUser(uid, u),HttpStatus.CREATED);
	}
	
	@PatchMapping("/user/{uid}")
	public ResponseEntity<User> updateUserParial(@PathVariable int uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUserParial(uid, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		return new ResponseEntity(service.deleteUser(uid),HttpStatus.ACCEPTED);
		
	} 
	
	
	
	
	
	
	
}

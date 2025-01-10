package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.training.userservice.dao.User;
import com.training.userservice.service.UserManagmentService;

@RestController
public class UserController {

	
	@Autowired
	UserManagmentService service;
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return new ResponseEntity<User>(service.getUserById(id),HttpStatus.OK);
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
	
	@DeleteMapping("/user/{name}")
	public ResponseEntity<String> deleteUser(@PathVariable String name) {
		return new ResponseEntity(service.deleteUser(name),HttpStatus.ACCEPTED);
		
	} 
	
	
	
	
	
	
	
}

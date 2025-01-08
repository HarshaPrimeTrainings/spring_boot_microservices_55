package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;

@RestController
public class UserController {

	List<User> userList = new ArrayList<>();
	
	public UserController() {
		userList.add(new User(1, "vivek", "HYD", "vivek@gmail.com"));
		userList.add(new User(2, "Joe", "Bang", "joe@gmail.com"));
		userList.add(new User(3, "chandler", "CHENNAI", "chandler@gmail.com"));
		userList.add(new User(4, "Rachel", "NYC", "rachel@gmail.com"));
		userList.add(new User(5, "Monika", "CND", "monika@gmail.com"));
		userList.add(new User(6, "Pheebe", "NYC", "pheebe@gmail.com"));
	}
	
	@RequestMapping(value="/users",method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return userList;
	}
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userList.stream().filter(usr-> usr.getUid() == id)
		 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
	}
	
	@RequestMapping("/user")
	public User getUserByIdRequestparam(@RequestParam int id) {
		return userList.stream().filter(usr-> usr.getUid() == id)
		 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		userList.add(user);
		return userList.stream().filter(usr-> usr.getUid() == user.getUid())
				 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
	}
	
	
	@RequestMapping(value = "/user/{uid}",method = RequestMethod.PUT)
	public User updateUser(@PathVariable int uid,@RequestBody User u) {
		
		User existing = userList.stream().filter(usr-> usr.getUid() == uid)
		 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
		
		existing.setName(u.getName());
		existing.setAddress(u.getAddress());
		existing.setEmail(u.getEmail());
		
		return existing;
	}
	
	
	@RequestMapping(value = "/user/{uid}",method = RequestMethod.PATCH)
	public User updateUserParial(@PathVariable int uid,@RequestBody User u) {
		
		User existing = userList.stream().filter(usr-> usr.getUid() == uid)
		 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
		
		existing.setName((u.getName()!=null) ? u.getName(): existing.getName());
		existing.setAddress((u.getAddress()!=null) ? u.getAddress(): existing.getAddress());
		existing.setEmail((u.getEmail()!=null) ? u.getEmail(): existing.getEmail());
		return existing;
	}
	
	@RequestMapping(value = "/user/{name}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String name) {
		User existing = userList.stream().filter(usr-> usr.getName().equalsIgnoreCase(name))
				 .findFirst().orElseThrow(()->new RuntimeException("User Not Found"));
		userList.remove(existing);
		return "User Removed with name : "+ name;
		
	} 
	
	
	
	
	
	
	
}

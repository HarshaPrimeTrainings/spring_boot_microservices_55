package com.training.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.exception.UserNotFoundException;

@Service
public class UserManagmentService {
	
	@Autowired
	UserRepository repo;
	
	
	
	@Transactional
	public List<User> execEmailProc(String name,String address) {
			return repo.userEmailProcedure(name,address);	
	}
	
	@Transactional
	public List<User> execProc() {
		return repo.callProcedure();
	}
	
	public User getUserByEmail(String email) {
		return repo.getuserwithemail(email);
	}
	
	public List<User> getAllUsers() {
		return (List<User>) repo.findAll();
	}
	
	
	public User getUserByname(String name) {
		return repo.getByName(name).orElseThrow(()->new UserNotFoundException(name));
	}
	

	public User getUserById(int id) {
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ id));
	}
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(int uid, User u) {
		User existing = repo.findById(uid).orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ uid));
		existing.setAddress(u.getAddress());
		existing.setEmail(u.getEmail());
		existing.setName(u.getName());
		return repo.save(existing);
		
	}

	public User updateUserParial(int uid, User u) {
		User existing = repo.findById(uid).orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ uid));
		existing.setName((u.getName() != null) ? u.getName() : existing.getName());
		existing.setAddress((u.getAddress() != null) ? u.getAddress() : existing.getAddress());
		existing.setEmail((u.getEmail() != null) ? u.getEmail() : existing.getEmail());
		return repo.save(existing);
	}

	public String deleteUser(int uid) {
		 repo.deleteById(uid);
		 return "User Deleted Successsfully";
	}

}

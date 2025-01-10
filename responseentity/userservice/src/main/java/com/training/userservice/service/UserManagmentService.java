package com.training.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.exception.UserNotFoundException;

@Service
public class UserManagmentService {
	
	List<User> userList = new ArrayList<>();

	public UserManagmentService() {
		userList.add(new User(1, "vivek", "HYD", "vivek@gmail.com"));
		userList.add(new User(2, "Joe", "Bang", "joe@gmail.com"));
		userList.add(new User(3, "chandler", "CHENNAI", "chandler@gmail.com"));
		userList.add(new User(4, "Rachel", "NYC", "rachel@gmail.com"));
		userList.add(new User(5, "Monika", "CND", "monika@gmail.com"));
		userList.add(new User(6, "Pheebe", "NYC", "pheebe@gmail.com"));
	}

	public List<User> getAllUsers() {
		return userList;
	}

	public User getUserById(int id) {
		return userList.stream().filter(usr -> usr.getUid() == id).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ id));
	}
	
	public User saveUser(User user) {
		userList.add(user);
		return userList.stream().filter(usr-> usr.getUid() == user.getUid())
				 .findFirst().orElseThrow(()->new UserNotFoundException("User Not Found With ID : "+ user.getUid()));
	}

	public User updateUser(int uid, User u) {
		User existing = userList.stream().filter(usr -> usr.getUid() == uid).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ uid));
		existing.setName(u.getName());
		existing.setAddress(u.getAddress());
		existing.setEmail(u.getEmail());

		return existing;
	}

	public User updateUserParial(int uid, User u) {
		User existing = userList.stream().filter(usr -> usr.getUid() == uid).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User Not Found With ID : "+ uid));
		existing.setName((u.getName() != null) ? u.getName() : existing.getName());
		existing.setAddress((u.getAddress() != null) ? u.getAddress() : existing.getAddress());
		existing.setEmail((u.getEmail() != null) ? u.getEmail() : existing.getEmail());
		return existing;
	}

	public String deleteUser(String name) {
		User existing = userList.stream().filter(usr -> usr.getName().equalsIgnoreCase(name)).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User Not Found With name : "+ name));
		userList.remove(existing);
		return "User Removed with name : " + name;

	}

}

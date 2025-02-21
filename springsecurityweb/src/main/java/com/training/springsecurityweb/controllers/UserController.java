package com.training.springsecurityweb.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.springsecurityweb.dao.Role;
import com.training.springsecurityweb.dao.Roles;
import com.training.springsecurityweb.dao.UserInfo;
import com.training.springsecurityweb.repository.RoleRepository;
import com.training.springsecurityweb.repository.UserDetailsRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	@Autowired
	UserDetailsRepository repo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/greet")
	public String greetuser(HttpServletRequest req,Model model) {
		 String user = req.getRemoteUser();
		 model.addAttribute("remoteuser",user);
		return "greet";
	}
	
	@GetMapping("/users")
	public String profileList(Model model) {
		List<UserInfo> userslist= (List<UserInfo>) repo.findAll();
		model.addAttribute("users",userslist);
		return "userlist";
	}
	
	@GetMapping("/user/{name}")
	public String profileDetails(@PathVariable("name") String name,Model model) {
		UserInfo user= repo.findByUsername(name).orElseThrow(()->new RuntimeException("User Not Found"));
		model.addAttribute("userdetail",user);
		return "profile";
	}
	
	
	
	@PostMapping("/save")
	public String save(UserInfo user, String rolelist) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		Set<Roles> roleSet = new HashSet<>();
		String roles[] = rolelist.split(",");
		Set inputrole = Set.of(roles);
		System.out.println(inputrole);

		inputrole.forEach(role -> {
			System.out.println(Role.valueOf(role.toString()));
			
			Roles rolefromDb = roleRepo.findByRole(Role.valueOf(role.toString()))
					.orElseThrow(() -> new RuntimeException("Role Not Found"));
			roleSet.add(rolefromDb);
		});
		user.setRoles(roleSet);
		repo.save(user);
		return "usersuccess";
	}
	

	
	
}

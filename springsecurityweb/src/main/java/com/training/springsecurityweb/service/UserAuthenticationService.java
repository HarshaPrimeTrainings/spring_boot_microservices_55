package com.training.springsecurityweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.springsecurityweb.dao.UserInfo;
import com.training.springsecurityweb.repository.UserDetailsRepository;

@Service
public class UserAuthenticationService implements UserDetailsService{
	
	@Autowired
	UserDetailsRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user = repo.findByUsername(username).orElseThrow(()-> new RuntimeException("Usernot found with "+ username));
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		 user.getRoles().stream().forEach(role->{
			 authorities.add((GrantedAuthority)()->role.getRole().name());
		 });
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
	

}

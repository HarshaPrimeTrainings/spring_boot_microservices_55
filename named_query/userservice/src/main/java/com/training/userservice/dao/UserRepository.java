package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer>{
	
	public Optional<User> getByName(String name);
	
	public List<User> findByAddress(String address);
	
	@Query(value = "select * from user where email = :email",nativeQuery = true)
	public User getuserwithemail(String email);
	

}

package com.training.userservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.NamedStoredProcedureQuery;



public interface UserRepository extends CrudRepository<User, Integer>{
	
	public Optional<User> getByName(String name);
	
	
	@Query(value = "select * from user where email = :email",nativeQuery = true)
	public User getuserwithemail(String email);
	
	
	@Procedure(procedureName = "user_email")
	public List<User> callProcedure();
	
	@Procedure(procedureName = "user_email_in")
	public List<User> userEmailProcedure(@Param("namein") String name,@Param("adressin")String address);
	

}

package com.training.springsecurityweb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.training.springsecurityweb.dao.UserInfo;

public interface UserDetailsRepository extends CrudRepository<UserInfo, Integer>{

 public Optional<UserInfo> findByUsername(String username);
}

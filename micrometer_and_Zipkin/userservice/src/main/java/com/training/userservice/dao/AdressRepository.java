package com.training.userservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Adress, Integer>{

	public Adress findByzip(Integer zip);
}

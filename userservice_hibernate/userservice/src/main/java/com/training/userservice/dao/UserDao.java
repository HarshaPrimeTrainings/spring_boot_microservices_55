package com.training.userservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public String saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		session.close();
		return "Data Saved";
	}
	
	public List<User> getAllUsers(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> ul= session.createQuery("FROM User").list();
		session.close();
		return ul;
	}
	
	public User getUserById(int uid) {
		Session session = sessionFactory.openSession();
		Transaction transaction  = session.beginTransaction();
		
		//Load Method will retrieve the Data from the cache. if Object not found it will throw null Pointer Exception
		User u = session.load(User.class, uid);
		
		//Get Method will retrieve the Data from the DataBase. if Object not found it will return null
		//User u = session.get(User.class, uid);
		session.close();
		return u;
	}
	
	public String deleteUser(int uid) {
		Session session = sessionFactory.openSession();
		Transaction transaction  = session.beginTransaction();
		User u = session.load(User.class, uid);
		session.delete(u);
		transaction.commit();
		session.close();
		return "User Deleted Successfully";
	}
	
	
	
}

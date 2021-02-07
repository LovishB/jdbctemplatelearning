package com.example.learningjdbctemplate.dao;

import java.util.List;

import  com.example.learningjdbctemplate.entity.User;


public interface UserDAO {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	User getById(int id);
	
	List<User> getAllUsers();
	
	String deleteById(int id);

}

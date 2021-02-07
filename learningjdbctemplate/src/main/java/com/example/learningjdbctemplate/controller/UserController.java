package com.example.learningjdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningjdbctemplate.dao.UserDAO;
import com.example.learningjdbctemplate.entity.User;
import com.example.learningjdbctemplate.logic.UserLogic;

@RestController
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userDAO.saveUser(user);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userDAO.updateUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userDAO.getById(id);
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUser() {
		 List<User> list = userDAO.getAllUsers();
		 System.out.print(new UserLogic().getTotalUsers(list));
		 return list;
	}
	
	
	

}

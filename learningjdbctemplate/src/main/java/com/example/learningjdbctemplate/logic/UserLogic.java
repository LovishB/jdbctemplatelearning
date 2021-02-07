package com.example.learningjdbctemplate.logic;

import java.util.List;

import com.example.learningjdbctemplate.entity.User;

public class UserLogic {
	
	public int getTotalUsers(List<User> list) {
		return list.size();
	}

}

package com.example.learningjdbctemplate.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private int id;
	private String fname;
	private String lname;
	
	public User(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	

}

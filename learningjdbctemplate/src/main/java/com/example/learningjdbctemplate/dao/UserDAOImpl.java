package com.example.learningjdbctemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.learningjdbctemplate.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String INSERT_USER_QUERY = "INSERT INTO user VALUES(?,?,?)";
	private static final String UPDATE_USER_QUERY = "UPDATE user SET fname=? WHERE id=?";
	private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id=?";
	private static final String GET_ALL_USERS = "SELECT * FROM user";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User saveUser(User user) {
		jdbcTemplate.update(INSERT_USER_QUERY,user.getId(),user.getFname(),user.getLname());
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_QUERY,user.getFname(),user.getId());
		return user;
	}

	@Override
	public User getById(int id) {

		return jdbcTemplate.queryForObject(GET_USER_BY_ID, (rs,rowNum) ->
				 new User(
						 rs.getInt("id"),
						 rs.getString("fname"),
						 rs.getString("lname")
						 )
		,id);
	}

	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query(GET_ALL_USERS,(rs,rowNum) ->
			new User(
				 rs.getInt("id"),
				 rs.getString("fname"),
				 rs.getString("lname")
				 )
				);
	}

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID,id);
		return "User got deleted with id : "+id;
	}

}

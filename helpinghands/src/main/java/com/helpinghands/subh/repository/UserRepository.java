package com.helpinghands.subh.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.helpinghands.subh.model.*;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
				
			return user;
		}
	}

	public User findById(long id) {
		return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
	}

	
	public List<User> findAll() {
		return jdbcTemplate.query("select * from user", new UserRowMapper());
	}
	public int deleteById(long id) {
	    return jdbcTemplate.update("delete from user where id=?", new Object[] {
	        id
	    });
	}
	public int insert(User user) {
		System.out.println(jdbcTemplate);
	    return jdbcTemplate.update("insert into user (name, email,password) " + "values(?,?, ?)",
	        new Object[] {
	             user.getName(),user.getEmail(), user.getPassword()
	        });
	}
	public int update(User user) {
	    return jdbcTemplate.update("update user " + " set name = ?, email = ? , password = ?  " + " where id = ?",
	        new Object[] {
	            user.getName(), user.getEmail(),user.getPassword(), user.getId()
	        });
	}
	public User checkLogin(User user) {
		try {
			
		
		return jdbcTemplate.queryForObject("select * from user where email = ? and  password = ? ",
				new Object[] {
						user.getEmail(),user.getPassword()
		},new BeanPropertyRowMapper<User>(User.class));
	
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}

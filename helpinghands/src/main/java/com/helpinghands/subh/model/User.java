package com.helpinghands.subh.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USER_TABLE database table.
 * 
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}
	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;



	public User() {
		
	}



	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}


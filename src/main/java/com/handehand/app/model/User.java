package com.handehand.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String identifier;

	private String name;

	private String surname;
	
	private String password;
	
	private String role;
	
	private String email;

	public User(){
		
	}
	
	public User(String identifier, String name, String surname, String password, String role, String email) {
		this.identifier = identifier;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	@Id
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User(" + identifier + ")";
	}
}

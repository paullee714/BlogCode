package com.woolbro.model;

public class User {
	
	String username;
	String password;
	String email;
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	//getter setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

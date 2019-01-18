package com.bryce.classes;

public class User {
	private String username;
	private String password;
	
	public User(final String username, final String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public String toString() {
		return String.format("%s %s", username, password);
	}
}

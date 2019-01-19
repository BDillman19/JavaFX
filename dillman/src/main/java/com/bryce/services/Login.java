package com.bryce.services;

import com.bryce.db.UserOperations;

public class Login {
	private UserOperations userOperations;
	
	public Login() {
		userOperations = new UserOperations();
	}
	
	//check that username and password match an entry in the DB
	public boolean login(final String username, final String password) {
		return userOperations.read(username)
				.map(user -> {
					if (!user.getPassword().equals(password)) {
						return false;
					}
					
					return true;
				})
				.orElse(false);
	}
}

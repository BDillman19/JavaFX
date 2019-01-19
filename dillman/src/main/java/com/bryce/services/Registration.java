package com.bryce.services;

import java.util.Optional;

import com.bryce.classes.User;
import com.bryce.db.UserOperations;

public class Registration {
	private UserOperations userOperations;
	
	public Registration() {
		userOperations = new UserOperations();
	}
	
	public Optional<User> registerUser(final String username, final String password) {
		if (userOperations.read(username).isPresent()) {
			return Optional.empty();
		}
		
		return userOperations.create(new User(username, password));
	}
}

package com.bryce.services;

import java.util.Optional;

import com.bryce.classes.User;
import com.bryce.db.UserOperations;

public class UserManagement {
	private UserOperations userOperations;
	User currentUser;
	
	public UserManagement(final User user) {
		userOperations = new UserOperations();
		currentUser = user;
	}
	
	//update Username
	public Optional<User> updateUsername(final String newUsername) {
		return userOperations.updateUsername(currentUser, newUsername);
	}
	
	//update password
	public Optional<User> updatePassword(final String newPassword) {
		return userOperations.updatePassword(currentUser, newPassword);
	}
	
	//delete User
	public String deleteCurrentUser() {
		return userOperations.delete(currentUser.getUsername());
	}
}

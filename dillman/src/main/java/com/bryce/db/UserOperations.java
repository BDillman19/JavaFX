package com.bryce.db;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.bryce.classes.User;

public class UserOperations {
	private DbOperations db;
	
	public UserOperations() {
		try {
			db = new DbOperations();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Optional<User> create(final User user) {
		try {
			if(!db.read(user.getUsername()).isPresent()) {
				return db.create(user.getUsername(), user.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public Optional<User> update(final User existingUser, final String newUsername, final String newPassword) {
		try {
			if(!db.read(existingUser.getUsername()).isPresent()) {
				return Optional.empty();
			}
			
			if(db.read(newUsername).isPresent()) {
				return Optional.empty();
			}
			
			return db.update(existingUser.getUsername(), newUsername, newPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public Optional<User> updateUsername(final User existingUser, final String newUsername) {
		try {
			if(!db.read(existingUser.getUsername()).isPresent()) {
				return Optional.empty();
			}
			
			if(db.read(newUsername).isPresent()) {
				return Optional.empty();
			}
			
			return db.updateUsername(existingUser.getUsername(), newUsername);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public Optional<User> updatePassword(final User existingUser, final String newPassword) {
		try {
			if(!db.read(existingUser.getUsername()).isPresent()) {
				return Optional.empty();
			}
			
			return db.updatePassword(existingUser.getUsername(), newPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public List<User> readAll() {
		try {
			return db.readAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public Optional<User> read(final String username) {
		try {
			return db.read(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public String delete(final String username) {
		try {
			if (!db.read(username).isPresent()) {
				return "User does not exist.";
			}
			
			return db.delete(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Delete failed.";
	}
	
}

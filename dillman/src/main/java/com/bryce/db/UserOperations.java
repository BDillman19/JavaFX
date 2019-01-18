package com.bryce.db;

import java.sql.SQLException;

import com.bryce.classes.User;

public class UserOperations {
	DbOperations db;
	
	public String create(final User user) {
		try {
			return db.create(user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Create Failed. SQLException has been thrown.";
	}
	
}

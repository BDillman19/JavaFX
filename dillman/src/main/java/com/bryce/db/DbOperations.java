package com.bryce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.bryce.classes.User;

public class DbOperations {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public DbOperations() throws SQLException {
		//Connect to the database
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
				"root", "password");
		
		//initialize a statement
		statement = connection.createStatement();
		
	}
	
	public String create(final String un, final String password) throws SQLException {
		Objects.requireNonNull(un);
		Objects.requireNonNull(password);
		
		statement.execute(String.format("INSERT INTO User (username, password) VALUES('%s','%s')", un, password));
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , un));
		if (resultSet.next()) {
			return new User(resultSet.getString("username"), resultSet.getString("password")).toString();
		}
		
		return "User was not created";
	}
	
	public List<String> readAll() throws SQLException {
		List<String> rows = new ArrayList<>();
		resultSet = statement.executeQuery("SELECT * FROM User");
		
		while(resultSet.next()) {
			rows.add(new User(resultSet.getString("username"), resultSet.getString("password")).toString());
		}
		
		return rows;
	}
	
	public String read(final String username) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'", username));
		
		if (resultSet.next()) {
			return new User(resultSet.getString("username"), resultSet.getString("password")).toString();
		}
		
		return String.format("Read failed. No User with username %s.", username);
	}
	
	public String delete(final String username) throws SQLException {
		statement.execute(String.format("DELETE FROM User WHERE username='%s'", username));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , username));
		if (resultSet.next()) {
			return "Delete failed.";
		}
		
		return "Delete Successful";
	}
	
	public String update(final String oldUsername,final String newUsername, final String newPassword) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , oldUsername));
		if (!resultSet.next()) {
			return String.format("Update failed. No User with username %s.", oldUsername);
		}
		
		statement.executeUpdate(String.format("UPDATE User SET username='%s', password='%s' WHERE username='%s'",
				newUsername, newPassword, oldUsername));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , newUsername));
		if(resultSet.next()) {
			return new User(resultSet.getString("username"), resultSet.getString("password")).toString();
		}
		
		return "Update failed.";
	}
}

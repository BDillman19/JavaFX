package com.bryce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.bryce.classes.User;

public class DbOperations {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	protected DbOperations() throws SQLException {
		//Connect to the database
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
				"root", "password");
		
		//initialize a statement
		statement = connection.createStatement();
		
	}
	
	protected Optional<User> create(final String un, final String password) throws SQLException {
		Objects.requireNonNull(un);
		Objects.requireNonNull(password);
		
		statement.execute(String.format("INSERT INTO User (username, password) VALUES('%s','%s')", un, password));
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , un));
		if (resultSet.next()) {
			return Optional.of(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return Optional.empty();
	}
	
	protected List<User> readAll() throws SQLException {
		List<User> rows = new ArrayList<>();
		resultSet = statement.executeQuery("SELECT * FROM User");
		
		while(resultSet.next()) {
			rows.add(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return rows;
	}
	
	protected Optional<User> read(final String username) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'", username));
		
		if (resultSet.next()) {
			return Optional.of(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return Optional.empty();
	}
	
	protected String delete(final String username) throws SQLException {
		statement.execute(String.format("DELETE FROM User WHERE username='%s'", username));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , username));
		if (resultSet.next()) {
			return "Delete failed.";
		}
		
		return "Delete Successful";
	}
	
	protected Optional<User> update(final String oldUsername,final String newUsername, final String newPassword) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , oldUsername));
		if (!resultSet.next()) {
			return Optional.empty();
		}
		
		statement.executeUpdate(String.format("UPDATE User SET username='%s', password='%s' WHERE username='%s'",
				newUsername, newPassword, oldUsername));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , newUsername));
		if(resultSet.next()) {
			return Optional.of(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return Optional.empty();
	}
	
	protected Optional<User> updateUsername(final String oldUsername,final String newUsername) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , oldUsername));
		if (!resultSet.next()) {
			return Optional.empty();
		}
		
		statement.executeUpdate(String.format("UPDATE User SET username='%s' WHERE username='%s'",
				newUsername, oldUsername));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , newUsername));
		if(resultSet.next()) {
			return Optional.of(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return Optional.empty();
	}
	
	protected Optional<User> updatePassword(final String username, final String newPassword) throws SQLException {
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , username));
		if (!resultSet.next()) {
			return Optional.empty();
		}
		
		statement.executeUpdate(String.format("UPDATE User SET password='%s' WHERE username='%s'",
			 newPassword, username));
		
		resultSet = statement.executeQuery(String.format("SELECT * FROM User WHERE username='%s'" , username));
		if(resultSet.next()) {
			return Optional.of(new User(resultSet.getString("username"), resultSet.getString("password")));
		}
		
		return Optional.empty();
	}
}

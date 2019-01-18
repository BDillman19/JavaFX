package com.bryce.db;

import java.sql.SQLException;

import org.junit.Before;

public class TestUserOperations {
	DbOperations ops;
	
	@Before
	public void before() throws SQLException {
		ops = new DbOperations();
	}
	
	
}

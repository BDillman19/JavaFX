package com.bryce.db;

import java.sql.SQLException;
import org.junit.Before;

public class TestDbOperations {
	DbOperations ops;
	
	@Before
	public void before() throws SQLException {
		ops = new DbOperations();
	}
	
//	@Test
//	public void testCreate() throws SQLException {
//		String username = "blahblah";
//		String password = "blah";
//		Optional<User> create = ops.create(username, password);
//		System.out.println(create.isPresent());
//	}
//	
//	@Test
//	public void testReadAll() throws SQLException {
//		List<User> create = ops.readAll();
//		create.stream()
//		.peek(user -> System.out.println(user.toString()))
//		.collect(Collectors.toList());
//	}
//	
//	@Test
//	public void testRead() throws SQLException {
//		Optional<User> read = ops.read("blahblah");
//		
//		System.out.println(read.isPresent());
//	}

//	@Test
//	public void testDelete() throws SQLException {
//		String delete = ops.delete("blahblah");
//		
//		System.out.println(delete);
//	}
	
//	@Test
//	public void testUpdate() throws SQLException {
//		Optional<User> update = ops.update("changed", "blah", "blahspassword");
//		
//		System.out.println(update.isPresent());
//	}
}

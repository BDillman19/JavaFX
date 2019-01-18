package com.bryce.db;

import java.sql.SQLException;

import org.junit.Before;

import com.bryce.db.DbOperations;

public class TestDbOperations {
	DbOperations ops;
	
	@Before
	public void before() throws SQLException {
		ops = new DbOperations();
	}
	
//	@Test
//	public void testCreate() throws SQLException {
//		String username = "changed";
//		String password = "notapassword";
//		String create = ops.create(username, password);
//		System.out.println(create);
//	}
//	
//	@Test
//	public void testReadAll() throws SQLException {
//		List<String> create = ops.readAll();
//		create.stream()
//		.peek(user -> System.out.println(user))
//		.collect(Collectors.toList());
//	}
//	
//	@Test
//	public void testRead() throws SQLException {
//		String read = ops.read("blah");
//		
//		System.out.println(read);
//	}
//
//	@Test
//	public void testDelete() throws SQLException {
//		String delete = ops.delete("blah");
//		
//		System.out.println(delete);
//	}
	
//	@Test
//	public void testUpdate() throws SQLException {
//		String update = ops.update("notBlah", "blah", "blahspassword");
//		
//		System.out.println(update);
//	}
}

package com.bryce.db;

import java.sql.SQLException;
import org.junit.Before;

public class TestUserOperations {
	UserOperations ops;
	
	@Before
	public void before() throws SQLException {
		ops = new UserOperations();
	}
	
//	@Test
//	public void testCreateNewUser() {
//		Optional<User> user = ops.create(new User("timBogart", "timmytwosneakers"));
//		
//		System.out.println(user.isPresent());
//	}
//	
//	@Test
//	public void testCreateExistingUser() {
//		Optional<User> user = ops.create(new User("timBogart", "timmytwosneakers"));
//		
//		System.out.println(user.isPresent());
//	}
	
//	@Test
//	public void testUpdateUnique() {
//		Optional<User> user = ops.update(new User("timBogart", "timmytwosneakers"), "jeffreyBogart", "oneeyedjeffrey");
//		
//		System.out.print(user.isPresent());
//	}
//	
//	@Test
//	public void testUpdateUnique() {
//		Optional<User> user = ops.update(new User("jeffreyBogart", "oneeyedjeffrey"), "jeffreyBogart", "oneeyedjeffrey");
//		
//		System.out.print(user.isPresent());
//	}
//	
//	@Test
//	public void testUpdateUsernameUnique() {
//		Optional<User> user = ops.updateUsername(new User("jeff", "oneeyedJeffrey"), "jeffreyBogart");
//		
//		System.out.print(user.isPresent());
//	}
//	
//	@Test
//	public void testUpdateUsernameDuplicate() {
//		Optional<User> user = ops.updateUsername(new User("jefferyBogart", "oneeyedjeffrey"), "blah");
//		
//		System.out.print(user.isPresent());
//	}
}

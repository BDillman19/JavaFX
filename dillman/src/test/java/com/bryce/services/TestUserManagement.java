package com.bryce.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.bryce.classes.User;

public class TestUserManagement {
	UserManagement manager;
	
	@Before
	public void setup() {
		manager = new UserManagement(new User("blah", "blahspassword"));
	}
	
	@Test
	public void testUpdateUsernameWithDuplicate() {
		String newUsername = "blah";
		
		Optional<User> user = manager.updateUsername(newUsername);
		
		assertFalse(user.isPresent());
	}
	
	@Test
	public void testUpdatePassword() {
		Optional<User> user = manager.updatePassword("blahsnewpassword");
		
		assertTrue(user.isPresent());
	}

}

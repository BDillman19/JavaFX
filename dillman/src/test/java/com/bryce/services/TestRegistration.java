package com.bryce.services;

import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.bryce.classes.User;

public class TestRegistration {
	Registration registrationService;
	
	@Before
	public void setup() {
		registrationService = new Registration();
	}
	
	@Test
	public void testRegisterUserWithNonUniqueUsername() {
		Optional<User> user = registrationService.registerUser("blah", "cloyd");
		
		assertFalse(user.isPresent());
	}

}

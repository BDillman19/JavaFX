package com.bryce.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestLogin {
	Login loginService;
	
	@Before
	public void setup() {
		loginService = new Login();
	}
	
	@Test
	public void testLoginWithGoodCredentials() {
		boolean loggedIn = loginService.login("blah", "blahspassword");
		
		assertTrue(loggedIn);
	}
	
	@Test
	public void testLoginWithBadCredentials() {
		boolean loggedIn = loginService.login("notausername", "notapassword");
		
		assertFalse(loggedIn);
	}
	
	@Test
	public void testLoginWithBadPassword() {
		boolean loggedIn = loginService.login("blah", "notblahspassword");
		
		assertFalse(loggedIn);
	}
}

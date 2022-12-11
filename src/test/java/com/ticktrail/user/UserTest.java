package com.ticktrail.user;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ticktrail.train.Reservation;

class UserTest {
	User userTest;
	
	@BeforeEach
	void setUp() {
		userTest = new User();
	}
	@Test
	void exist() {
		boolean result=userTest.exist("leoandert41@gmail.com");
		assertTrue(result);
	}
	
	@Test
	void existKO() {
		boolean result=userTest.exist("testKO@gmail.com");
		assertFalse(result);
	}
	
	@Test
	void isLogin_logout() {
		try {
			userTest.login("leoandert41@gmail.com");
			boolean result= userTest.isLogin();
			assertTrue(result);
			userTest.logout();
			result= userTest.isLogin();
			assertFalse(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

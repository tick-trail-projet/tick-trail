package com.ticktrail.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatternTest {
	Pattern pattern;
	
	@BeforeEach
	void setUp() {
		pattern = new Pattern();
	}
	
	@Test
	void checkEmail() {
		assertTrue(pattern.checkEmail("test@test.com"));
	}
	
	@Test
	void checkPassword() {
		assertTrue(pattern.checkPassword("=s01545r4reerr"));
	}
	
	@Test
	void checkName() {
		assertTrue(pattern.checkName("Test"));
	}
	
	@Test
	void checkSurname() {
		assertTrue(pattern.checkSurname("surname"));
	}
	
	@Test
	void checkLocation() {
		assertTrue(pattern.checkLocation("Vosges"));
	}
	
	@Test
	void checkPhone() {
		assertTrue(pattern.checkPhone("0105262411"));
	}
	
	
	@Test
	void checkEmailKO() {
		assertFalse(pattern.checkEmail("testtest.com"));
	}
	
	@Test
	void checkPasswordKO() {
		assertFalse(pattern.checkPassword("s01A45r4re!eo"));
	}
	
	@Test
	void checkNameKO() {
		assertFalse(pattern.checkName("15Test"));
	}
	
	@Test
	void checkSurnameKO() {
		assertFalse(pattern.checkSurname("10surname"));
	}
	
	@Test
	void checkLocationKO() {
		assertFalse(pattern.checkLocation("Vosges45"));
	}
	
	@Test
	void checkPhoneKO() {
		assertFalse(pattern.checkPhone("010526241185"));
	}
}

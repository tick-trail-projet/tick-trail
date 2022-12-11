package com.ticktrail.train;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ticktrail.user.User;

class BookTest {
	Book bookTest;
	User user;
	
	
	@BeforeEach
	void setUp() {
		bookTest = new Book();
		user = new User();
	}
	
	@Test
	void getLastBook() {
		try {
			user.login("leoandert41@gmail.com");
			
			bookTest.bookTrain(10,"NICE","PARIS","22/11/2022","23/11/2022");
			Map<String, Object> result = bookTest.getLastBook();
			assertEquals(10, result.get("price"));
			assertEquals("NICE", result.get("from"));
			assertEquals("PARIS", result.get("to"));
			
			User user = new User();
			
			bookTest.runQuery("DELETE FROM trips WHERE price = 10 AND from_schedule = 'NICE' AND to_schedule ='PARIS' AND user_id = \""
					+ user.getWithToken().get("id") + "\"");
		
			user.logout();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

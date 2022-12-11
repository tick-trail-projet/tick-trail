package com.ticktrail.basic;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateCheckerTest {
	DateChecker dateChecker;
	
	@BeforeEach
	void setUp() {
		dateChecker = new DateChecker("2013-11-09");
	}
	
	@Test
	void isValid() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		dateChecker.setDate(formatter.format(cal.getTime()));
		assertTrue(dateChecker.isValid());
	}
	
	@Test
	void isValidKO() {
		assertFalse(dateChecker.isValid());
	}
	
	@Test
	void decompose() {
		Map<String, Integer> map = dateChecker.decompose();
		assertEquals(2013,map.get("year"));
		assertEquals(11,map.get("month"));
		assertEquals(9,map.get("day"));
		
	}
}

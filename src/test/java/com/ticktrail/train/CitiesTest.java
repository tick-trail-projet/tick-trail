package com.ticktrail.train;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CitiesTest {
	Cities cities1;
	Cities cities2;
	
	@BeforeEach
	void setUp() {
		cities1 = new Cities("BLOIS");
		cities2 = new Cities("PARIS");
	}
	
	@Test
	void calculatePrice() {
		int result = cities1.calculatePrice(cities2);
		assertEquals(31,result);
	}
	
	@Test
	void calculeSchedule() {
		int result = cities1.calculeSchedule(cities2);
		assertEquals(2,result);
	}
	
	@Test
	void distanceInKmBetweenEarthCoordinates() {
		double result = cities1.distanceInKmBetweenEarthCoordinates(43.140491048348736,5.749815526229215, 46.097617863456954,3.204865220044901);
		assertEquals(385.55825891396717,result);
	}
	
}

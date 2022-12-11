package com.ticktrail.database;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ticktrail.basic.Pattern;

class StorageTest {
	Storage storageTest;
	
	@BeforeEach
	void setUp() {
		try {
			storageTest = new Storage("./src/main/java/com/ticktrail/database/trip.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void read_writefile() {
		
		try {
			storageTest.write_file("Blois,Paris,2022-12-07");
			String result = storageTest.read_file();
			assertEquals("Blois,Paris,2022-12-07", result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void exists() {
		boolean result = storageTest.exists("./src/main/java/com/ticktrail/database/trip.txt");
		assertTrue(result);
	}
	
	@Test
	void existsKO() {
		boolean result = storageTest.exists("./src/main/java/com/ticktrail/database/tripKO.txt");
		assertFalse(result);
	}
}

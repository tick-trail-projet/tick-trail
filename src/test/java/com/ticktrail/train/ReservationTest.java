package com.ticktrail.train;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ticktrail.database.Storage;
import com.ticktrail.user.User;

class ReservationTest {
	Reservation reservationTest;
	User user;
	
	@BeforeEach
	void setUp() {
		reservationTest = new Reservation();
		user = new User();
	}
	
	@Test
	void add_delete_MyReservation() {
		ArrayList<Trip> listResult = null;
		int length=0;
		try {
			user.login("leoandert41@gmail.com");
			listResult = reservationTest.MyReservation();
			length = listResult.size();
			User user = new User();
			reservationTest.runQuery(
					"INSERT INTO `trips`(`price`,`from`,`to`,`from_schedule`,`to_schedule`,`user_id`) VALUES ('45','NICE','PARIS','22/11/2022','23/11/2022','" + user.getWithToken().get("id") + "')");
			
			listResult = reservationTest.MyReservation();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertEquals(length + 1,listResult.size());
		
		try {
			reservationTest.deleteReservation("NICE","PARIS",45,"22/11/2022","23/11/2022");
			listResult = reservationTest.MyReservation();
			assertEquals(length,listResult.size());
			user.logout();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
}

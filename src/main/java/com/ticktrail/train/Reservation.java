package com.ticktrail.train;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.ticktrail.database.Mysql;
import com.ticktrail.user.User;

import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class Reservation extends Mysql {
    public Reservation() {
        super();
    }

    public void addReservation(int train_id) throws IOException {
        User user = new User();
        super.runQuery(
                "INSERT INTO `reservations`(`user_id`,`train_id`) VALUES ('" + user.getWithToken().get("id") + "','"
                        + train_id + "')");
    }

    public void Reserver() {

    }

    public ArrayList<Trip> simulation(String from, String to, String from_schedule) {
        double number = randomNumber(2, 10);
        ArrayList<Trip> list = new ArrayList<Trip>();
        for (int i = 0; i < number; i++) {
            Cities city_from = new Cities(from);
            Cities city_to = new Cities(to);
            int randomNumber = randomNumber(Integer.parseInt(
                    new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())), 24);
            list.add(
                    new Trip(from, to, city_from.calculatePrice(city_to),
                            from_schedule + " "
                                    + randomNumber
                                    + "h",
                            from_schedule + " " + (randomNumber + city_from.calculeSchedule(city_to)) + "h"));
        }
        return list;
    }

    public int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public ArrayList<Trip> MyReservation() throws IOException, SQLException {
        ArrayList<Trip> list = new ArrayList<Trip>();
        User user = new User();
        ResultSet rs = super.getQuery("SELECT * FROM trains WHERE id = \"" + user.getWithToken().get("id") + "\"");
        while (rs.next()) {
            Trip trip = new Trip(rs.getString("from"), rs.getString("to"), rs.getInt("price"),
                    rs.getString("from_schedule"), rs.getString("to_schedule"));
            list.add(trip);
        }
        return list;
    }

    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        System.out.println(reservation.randomNumber(Integer.parseInt(
                new SimpleDateFormat("HH").format(Calendar.getInstance().getTime())), 24));

    }
}

package com.ticktrail.train;

import java.io.IOException;
import java.util.Map;

import com.ticktrail.database.Mysql;
import com.ticktrail.user.User;

public class Book extends Mysql {
    public Book() {
        super();
    }

    public void bookTrain(int price, String from, String to, String from_schedule, String to_schedule)
            throws IOException {
        User user = new User();
        super.runQuery(
                "INSERT INTO `trips`(`price`,`from`,`to`,`from_schedule`,`to_schedule`,`user_id`) VALUES ('"
                        + price + "','" + from + "','" + to + "','" + from_schedule + "','"
                        + to_schedule + "','" + user.getWithToken().get("id") + "')");
    }

    public Map<String, Object> getLastBook() throws IOException {
        User user = new User();
        return super.getSingleQuery(
                "SELECT * FROM trips WHERE user_id = \"" + user.getWithToken().get("id") + "\" ORDER BY id DESC LIMIT 1");
    }

    public double randomNumber(int min, int max) {
        return Math.random() * (max - min + 1) + min;
    }

}

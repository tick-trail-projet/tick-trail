package com.ticktrail.train;

import java.util.Map;

import com.ticktrail.database.Mysql;

public class Book extends Mysql {
    public Book() {
        super();
    }

    public void bookTrain(String from, String to, String from_schedule, String to_schedule) {
        super.runQuery(
                "INSERT INTO `trips`(`price`,`from`,`to`,`from_schedule`,`to_schedule`) VALUES ('"
                        + randomNumber(50, 100) + "','" + from + "','" + to + "','" + from_schedule + "','"
                        + to_schedule
                        + "')");
    }

    public double randomNumber(int min, int max) {
        return Math.random() * (max - min + 1) + min;
    }

}

package com.ticktrail.train;

import java.util.Map;

import com.ticktrail.database.Mysql;

public class Train extends Mysql {
    public Train() {
        super();
    }

    public void addTrain() {
        super.runQuery("INSERT INTO `trains`(`seats_available`,`seats_use`,`available`) VALUES ('"
                + randomNumber(50, 100) + "')");
    }

    public Map<String, Object> getAvailableTrain() {
        return super.getSingleQuery("SELECT * FROM trains WHERE trains.available = \"" + 0 + "\"");
    }

    public double randomNumber(int min, int max) {
        return Math.random() * (max - min + 1) + min;
    }
}

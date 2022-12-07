package com.ticktrail.train;

import com.ticktrail.database.Mysql;

public class Reservation extends Mysql {
    public Reservation() {
        super();
    }

    public void addReservation(int user_id, int train_id) {
        super.runQuery("INSERT INTO `reservations`(`user_id`,`train_id`) VALUES ('" + user_id + "','" + train_id + "')");
    }
}

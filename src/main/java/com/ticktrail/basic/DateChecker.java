package com.ticktrail.basic;

public class DateChecker {
    private String date;

    public DateChecker(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateChecker date(String date) {
        setDate(date);
        return this;
    }
}

package com.ticktrail.train;

public class Trip {
    private String from;
    private String to;
    private int price;
    private String from_schedule;
    private String to_schedule;

    public Trip(String from, String to, int price, String from_schedule, String to_schedule) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.from_schedule = from_schedule;
        this.to_schedule = to_schedule;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom_schedule() {
        return this.from_schedule;
    }

    public void setFrom_schedule(String from_schedule) {
        this.from_schedule = from_schedule;
    }

    public String getTo_schedule() {
        return this.to_schedule;
    }

    public void setTo_schedule(String to_schedule) {
        this.to_schedule = to_schedule;
    }

    public Trip from(String from) {
        setFrom(from);
        return this;
    }

    public Trip to(String to) {
        setTo(to);
        return this;
    }

    public Trip price(int price) {
        setPrice(price);
        return this;
    }

    public Trip from_schedule(String from_schedule) {
        setFrom_schedule(from_schedule);
        return this;
    }

    public Trip to_schedule(String to_schedule) {
        setTo_schedule(to_schedule);
        return this;
    }
}

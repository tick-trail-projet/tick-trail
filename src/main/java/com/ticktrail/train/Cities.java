package com.ticktrail.train;

import java.util.Map;

import com.ticktrail.database.Mysql;

public class Cities extends Mysql {
    private String name;
    private double longitude;
    private double latitude;

    public Cities(String name) {
        super();
        this.name = name;
        Map<String, Object> data = super.getSingleQuery("SELECT * FROM cities WHERE name = \"" + name + "\"");
        this.longitude = Double.parseDouble((String) data.get("longitude"));
        this.latitude = Double.parseDouble((String) data.get("latitude"));
    }

    public int calculatePrice(Cities cities) {
        int number_of_km = (int) this.distanceInKmBetweenEarthCoordinates(this.getLatitude(), this.getLongitude(),
                cities.getLatitude(), cities.getLongitude());
        return (int) ((int) number_of_km * 0.2);
    }

    public int calculeSchedule(Cities cities) {
        int number_of_km = (int) this.distanceInKmBetweenEarthCoordinates(this.getLatitude(), this.getLongitude(),
                cities.getLatitude(), cities.getLongitude());
        return (int) ((int) number_of_km / 60);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double degreesToRadians(Double degrees) {
        return degrees * Math.PI / 180;
    }

    public double distanceInKmBetweenEarthCoordinates(double lat1, double lon1, double lat2, double lon2) {
        var earthRadiusKm = 6371;

        var dLat = degreesToRadians(lat2 - lat1);
        var dLon = degreesToRadians(lon2 - lon1);

        lat1 = degreesToRadians(lat1);
        lat2 = degreesToRadians(lat2);

        var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadiusKm * c;
    }

    public static void main(String[] args) {
        Cities cities1 = new Cities("BLOIS");
        Cities cities2 = new Cities("PARIS");
        System.out.println(cities1.calculeSchedule(cities2));
    }
}

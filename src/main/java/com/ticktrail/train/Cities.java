package com.ticktrail.train;

import java.util.Map;

import com.ticktrail.database.Mysql;

/**
 * classe decrivant les coordonnees d'une ville
 */
public class Cities extends Mysql {
    private String name;
    private double longitude;
    private double latitude;
	
	/**
	 * constructeur d'une ville
	 * @param name nom de la ville
	 */
    public Cities(String name) {
        super();
        this.name = name;
        Map<String, Object> data = super.getSingleQuery(
                "SELECT * FROM cities WHERE name = \"" + name.toUpperCase().trim() + "\"");
        this.longitude = Double.parseDouble((String) data.get("longitude"));
        this.latitude = Double.parseDouble((String) data.get("latitude"));
    }
	
	/**
	 * calcul du prix du trajet par rapport a la distance entre 2 villes
	 *
	 * @param cities ville a comparer
	 * @return le prix
	 */
    public int calculatePrice(Cities cities) {
        int number_of_km = (int) this.distanceInKmBetweenEarthCoordinates(this.getLatitude(), this.getLongitude(),
                cities.getLatitude(), cities.getLongitude());
        return (int) ((int) number_of_km * 0.2);
    }
	
	/**
	 * calcul de la longueur d'un trajet entre 2 villes
	 *
	 * @param cities ville a comparer
	 * @return le nombre de kilometre
	 */
    public int calculeSchedule(Cities cities) {
        int number_of_km = (int) this.distanceInKmBetweenEarthCoordinates(this.getLatitude(), this.getLongitude(),
                cities.getLatitude(), cities.getLongitude());
        return (int) ((int) number_of_km / 60);
    }
	
	/**
	 * retourne le nom de la ville
	 *
	 * @return le nom de la ville
	 */
    public String getName() {
        return this.name;
    }
	
	/**
	 * positionne le nom de la ville
	 *
	 * @param name le nom de la ville
	 */
    public void setName(String name) {
        this.name = name;
    }
	
	/**
	 * retourne la coordonnee longitude de la ville
	 *
	 * @return la coordonnee longitude de la ville
	 */
    public double getLongitude() {
        return this.longitude;
    }
	
	/**
	 * positionne la coordonnee longitude de la ville
	 *
	 * @param longitude la coordonnee longitude de la ville
	 */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
	
	/**
	 * retourne la coordonnee latitude de la ville
	 *
	 * @return la coordonnee latitude de la ville
	 */
    public double getLatitude() {
        return this.latitude;
    }
	
	/**
	 * positionne la coordonnee latitude de la ville
	 *
	 * @param latitude la coordonnee latitude de la ville
	 */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
	
	/**
	 * conversion degree en radian
	 *
	 * @param degrees valeur en degree
	 * @return la valeur en radian
	 */
    public double degreesToRadians(Double degrees) {
        return degrees * Math.PI / 180;
    }
	
	/**
	 * distance entre 2 coordonnees
	 * @param lat1 latitude
	 * @param lon1 longitude
	 * @param lat2 latitude
	 * @param lon2 longitude
	 * @return la distance
	 */
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

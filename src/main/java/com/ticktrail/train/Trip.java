package com.ticktrail.train;

/**
 * classe decrivant un trajet
 */
public class Trip {
	private String from;
	private String to;
	private int price;
	private String from_schedule;
	private String to_schedule;

	/**
	 * constructeur
	 *
	 * @param from          origine
	 * @param to            destinataire
	 * @param price         prix
	 * @param from_schedule heure de depart
	 * @param to_schedule   heure d'arrivee
	 */
	public Trip(String from, String to, int price, String from_schedule, String to_schedule) {
		this.from = from;
		this.to = to;
		this.price = price;
		this.from_schedule = from_schedule;
		this.to_schedule = to_schedule;
	}

	/**
	 * constructeur
	 */
	public Trip() {

	}

	/**
	 * retourne la destination origine
	 * 
	 * @return la destination origine
	 */
	public String getFrom() {
		return this.from;
	}

	/**
	 * postionne la destination origine
	 * 
	 * @param from la destination origine
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * retourne la destination
	 * 
	 * @return la destination
	 */
	public String getTo() {
		return this.to;
	}

	/**
	 * postionne la destination
	 * 
	 * @param to la destination
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * retourne le prix
	 * 
	 * @return le prix
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * postionne le prix
	 * 
	 * @param price le prix
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * retourne l'heure de depart
	 * 
	 * @return l'heure de depart
	 */
	public String getFrom_schedule() {
		return this.from_schedule;
	}

	/**
	 * postionne l'heure de depart
	 *
	 * @param from_schedule
	 */
	public void setFrom_schedule(String from_schedule) {
		this.from_schedule = from_schedule;
	}

	/**
	 * retourne l'heure d'arrivee
	 * 
	 * @return l'heure d'arrivee
	 */
	public String getTo_schedule() {
		return this.to_schedule;
	}

	/**
	 * postionne l'heure d'arrivee
	 * 
	 * @param to_schedule l'heure d'arrivee
	 */
	public void setTo_schedule(String to_schedule) {
		this.to_schedule = to_schedule;
	}

	/**
	 * recupere un trajet a partir d'une destination origine
	 *
	 * @param from destination origine
	 * @return le trajet
	 */
	public Trip from(String from) {
		setFrom(from);
		return this;
	}

	/**
	 * recupere un trajet a partir d'une destination
	 * 
	 * @param to destination
	 * @return le trajet
	 */
	public Trip to(String to) {
		setTo(to);
		return this;
	}

	/**
	 * recupere un trajet a partir d'un prix
	 *
	 * @param price le prix
	 * @return le trajet
	 */
	public Trip price(int price) {
		setPrice(price);
		return this;
	}

	/**
	 * recupere un trajet a partir d'une heure de depart
	 *
	 * @param from_schedule heure de depart
	 * @return le trajet
	 */
	public Trip from_schedule(String from_schedule) {
		setFrom_schedule(from_schedule);
		return this;
	}

	/**
	 * recupere un trajet a partir d'une heure de destination
	 *
	 * @param to_schedule heure de destination
	 * @return le trajet
	 */
	public Trip to_schedule(String to_schedule) {
		setTo_schedule(to_schedule);
		return this;
	}
}

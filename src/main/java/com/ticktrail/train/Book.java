package com.ticktrail.train;

import java.io.IOException;
import java.util.Map;

import com.ticktrail.database.Mysql;
import com.ticktrail.user.User;

/**
 * classe gerant les interactions entre la reservation d'un trajet et la BDD
 */
public class Book extends Mysql {
	
	/**
	 * constructeur
	 */
    public Book() {
        super();
    }
	
	/**
	 * insertion en BDD de la reservation
	 *
	 * @param price prix
	 * @param from origine
	 * @param to destination
	 * @param from_schedule heure d'arrivee
	 * @param to_schedule heure de depart
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    public void bookTrain(int price, String from, String to, String from_schedule, String to_schedule)
            throws IOException {
        User user = new User();
        super.runQuery(
                "INSERT INTO `trips`(`price`,`from`,`to`,`from_schedule`,`to_schedule`,`user_id`) VALUES ('"
                        + price + "','" + from + "','" + to + "','" + from_schedule + "','"
                        + to_schedule + "','" + user.getWithToken().get("id") + "')");
    }
	
	/**
	 * recupere la derniere reservation d'un utlisateur
	 *
	 * @return la derniere reservation d'un utlisateur
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    public Map<String, Object> getLastBook() throws IOException {
        User user = new User();
        return super.getSingleQuery(
                "SELECT * FROM trips WHERE user_id = \"" + user.getWithToken().get("id") + "\" ORDER BY id DESC LIMIT 1");
    }
	
	/**
	 * generation d'un nombre aleatoire compris entre 2 valeurs
	 *
	 * @param min valeur min
	 * @param max valeur max
	 * @return le nombre aleatoire
	 */
    public double randomNumber(int min, int max) {
        return Math.random() * (max - min + 1) + min;
    }

}

package com.ticktrail.train;

import java.util.Map;

import com.ticktrail.database.Mysql;

/**
 * classe gerant les interactions entre les trains et la BDD
 */
public class Train extends Mysql {
	
	/**
	 * constructeur
	 */
    public Train() {
        super();
    }
	
	/**
	 * ajout d'un train en base de donnée
	 */
    public void addTrain() {
        super.runQuery("INSERT INTO `trains`(`seats_use`) VALUES ('"
                + randomNumber(50, 100) + "')");
    }
	
	/**
	 * recupere  la liste des trains disponibles
	 *
	 * @return la liste des trains disponibles
	 */
    public Map<String, Object> getAvailableTrain() {
        return super.getSingleQuery(
                "SELECT * FROM trains WHERE trains.available = \"" + 0 + "\" ORDER BY RAND() LIMIT 1");
    }
	
	/**
	 * generation d'un nombre aleatoire entre 2 valeurs
	 *
	 * @param min valeur min
	 * @param max valeur max
	 * @return le nombre aleatoire
	 */
    public double randomNumber(int min, int max) {
        return Math.random() * (max - min + 1) + min;
    }
}

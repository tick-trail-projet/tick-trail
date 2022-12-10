package com.ticktrail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Gestion des horaires
 */
public class Horaires {
    private int jour;
    private int mois;
    private int annee;
    private String heure;
	
	/**
	 * constructeur
	 * @param jour jour
	 * @param mois mois
	 * @param annee annee
	 * @param heure heure
	 */
    public Horaires(int jour, int mois, int annee, String heure) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
    }
	
	/**
	 * verifie la validite de la date et l'heure
	 * @return true si la date est correcte
	 */
    public boolean check() {
        if (checkDate() == true && checkHeure() == true) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * verifie la validite de la date
	 * @return true si la date est correcte
	 */
    public boolean checkDate() {
        if (dateValidation(getJour() + "/" + getMois() + "/" + getAnnee())) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * verifie la validite de l'heure
	 * @return true si l'heure est correcte
	 */
    public boolean checkHeure() {
        String[] heure_ = getHeure().split(":");
        try {
            int hours = Integer.parseInt(heure_[0]);
            int minutes = Integer.parseInt(heure_[1]);
            if (heure_.length == 2 && hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
	
	/**
	 * verifie le format de la date
	 * @param date date
	 * @return true si le format de la date est correct
	 */
    private static boolean dateValidation(String date) {
        boolean status = false;
        if (datePattern(date)) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                status = true;
            } catch (Exception e) {
                status = false;
            }
        }
        return status;
    }
	
	/**
	 * verifie le format de la date
	 * @param date date
	 * @return true si le format de la date est correct
	 */
    static boolean datePattern(String date) {
        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
    }
	
	/**
	 * retourne le jour
	 * @return le jour
	 */
    public int getJour() {
        return this.jour;
    }
	
	/**
	 * positionne le jour
	 * @param jour le jour
	 */
    public void setJour(int jour) {
        this.jour = jour;
    }
	
	/**
	 * retourne le mois
	 * @return le mois
	 */
    public int getMois() {
        return this.mois;
    }
	
	/**
	 * positionne le mois
	 * @param mois le mois
	 */
    public void setMois(int mois) {
        this.mois = mois;
    }
	
	/**
	 * retourne l'annee
	 * @return l'annee
	 */
    public int getAnnee() {
        return this.annee;
    }
	
	/**
	 * positionne l'annee
	 * @param annee l'annee
	 */
    public void setAnnee(int annee) {
        this.annee = annee;
    }
	
	/**
	 * retourne l'heure
	 * @return l'heure
	 */
    public String getHeure() {
        return this.heure;
    }
	
	/**
	 * positionne l'heure
	 * @param heure l'heure
	 */
    public void setHeure(String heure) {
        this.heure = heure;
    }
}

package com.ticktrail.user;

import java.io.IOException;
import java.util.Map;

/**
 * interface de l'utilisateur
 */
public interface UserInterface {
	
	/**
	 * creation d'un utilisateur
	 */
    public void create(String name, String password, String surname, String phone, String email,
            String city);
	
	/**
	 * recupere une liste d'utilisateur a partir d'un email
	 */
    public Map<String, Object> get(String email);
	
	/**
	 * verifie si l'utlisateur existe
	 */
    public boolean exist(String email);
	
	/**
	 * connection de l'utilisateur
	 */
    public void login(String email) throws IOException;
	
	/**
	 * deconnection de l'utilisateur
	 */
    public void logout() throws IOException;
}

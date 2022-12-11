package com.ticktrail.basic;

import org.mindrot.jbcrypt.BCrypt;

/**
 * classe gerant les mot de passe
 */
public class Password {
    /**
     * genere un mot de passe hashe
     * 
     * @return passwd le mot de passe encrypté
     */
    public String hashPassword(String password) {
        String passwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwd;
    }

    /**
     * verification du mot de passe par rapport au pan hashe
     *
     * @param password         mot de passe
     * @param encrypt_Password mot de passe hashe
     * @return true si le mot de passe est correcte sinon false
     */
    public boolean checkPassword(String password, String encrypt_Password) {
        return BCrypt.checkpw(password, encrypt_Password);
    }
}

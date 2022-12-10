package com.ticktrail;

import org.mindrot.jbcrypt.BCrypt;

/**
 * classe gerant le mot de passe
 */
public class Password {
    String plainTextPasswd = "123";
	
	/**
	 * genere un mot de passe hashe
	 * @return
	 */
    public String generatePasswdForStorage() {
        String passwd = BCrypt.hashpw(plainTextPasswd, BCrypt.gensalt());
        return passwd;
    }
	
	/**
	 * verifie le mot de passe
	 * @param encrypt_Password mot de passe chiffre
	 * @return true si le mot de passe est correcte sinon false
	 */
    public boolean checkPassword(String encrypt_Password) {
        return BCrypt.checkpw(plainTextPasswd, encrypt_Password);
    }

    public static void main(String[] args) {
        Password test = new Password();
        System.out.println(test.generatePasswdForStorage());
        System.out.println(test.checkPassword("$2a$10$jQfbiZHErbdm0X7UdkYRtOCYLcsQHENN1UBVIdX/xAE3rsCYCGZpW"));
    }
}

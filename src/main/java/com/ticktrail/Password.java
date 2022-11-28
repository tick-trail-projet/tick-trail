package com.ticktrail;

import java.util.Base64;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    String plainTextPasswd = "123";

    public String generatePasswdForStorage() {
        String passwd = BCrypt.hashpw(plainTextPasswd, BCrypt.gensalt());
        return passwd;
    }

    public boolean checkPassword(String encrypt_Password) {
        return BCrypt.checkpw(plainTextPasswd, encrypt_Password);
    }

    public static void main(String[] args) {
        Password test = new Password();
        System.out.println(test.generatePasswdForStorage());
        System.out.println(test.checkPassword("$2a$10$jQfbiZHErbdm0X7UdkYRtOCYLcsQHENN1UBVIdX/xAE3rsCYCGZpW"));
    }
}

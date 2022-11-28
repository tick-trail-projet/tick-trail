package com.ticktrail.controllers;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Register {
    @FXML
    TextField email;

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    TextField password;

    @FXML
    TextField confirm_password;

    @FXML
    TextField phone;

    @FXML
    TextField localion;

    @FXML
    Button loginButton;

    @FXML
    void btnOnRegisterClicked(ActionEvent event) {
        if (email != null) {
            System.out.println(email);
            User user = new User();
            if (!user.exist(email.getText())) {
                System.out.println("ici1");
                if (password.getText().equals(confirm_password.getText())) {
                    System.out.println("same password");
                    user.create(name.getText(), hashPassword(password.getText()), surname.getText(), phone.getText(),
                            email.getText(), null, null);
                    System.out.println("ici");
                }
            } else {
                System.out.println("User already exist");
            }
        }
    }

    public String hashPassword(String password) {
        String passwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwd;
    }
}

package com.ticktrail.controllers;

import java.io.IOException;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.FxmlLoader;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Login {
    @FXML
    TextField email;

    @FXML
    TextField password;

    @FXML
    void btnOnLoginClicked(ActionEvent event) throws IOException {
        if (email != null && password != null) {
            User user = new User();
            if (user.exist(email.getText())) {
                if (checkPassword(password.getText(), (String) user.get(email.getText()).get("password"))) {
                    user.login(email.getText());
                    FxmlLoader fxmlLoader = new FxmlLoader();
                    fxmlLoader.changePage("homePage", event);
                    System.out.println("Mot de passe correct");
                } else {
                    System.out.println("Mot de passe incorrect");
                }
            } else {
                System.out.println("Utilisateur introuvable");
            }
        }
    }

    public boolean checkPassword(String password, String encrypt_Password) {
        return BCrypt.checkpw(password, encrypt_Password);
    }
}

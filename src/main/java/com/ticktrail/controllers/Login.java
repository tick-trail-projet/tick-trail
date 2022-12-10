package com.ticktrail.controllers;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.FxmlLoader;
import com.ticktrail.basic.Notification;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * classe decrivant la connection
 */
public class Login {
    @FXML
    TextField email;

    @FXML
    TextField password;
	
	/**
	 * conenction du user
	 *
	 * @param event evenement de login
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnOnLoginClicked(ActionEvent event) throws IOException {
        if (email != null && password != null) {
            User user = new User();
            if (user.exist(email.getText())) {
                if (checkPassword(password.getText(), (String) user.get(email.getText()).get("password"))) {
                    user.login(email.getText());
                    FxmlLoader fxmlLoader = new FxmlLoader();
                    fxmlLoader.changePage("homePage", event);
                    Notification notification = new Notification("Notification",
                            "Vous vous etes connecté avec success.",
                            "success");
                    notification.runNotification();
                } else {
                    Notification notification = new Notification("Erreur", "Mot de passe incorrect.",
                            "error");
                    notification.runNotification();
                }
            } else {
                Notification notification = new Notification("Erreur", "Aucun compte est associé avec cet email.",
                        "error");
                notification.runNotification();
            }
        }
    }
	
	/**
	 * verification du mot de passe par rapport au pan hashe
	 *
	 * @param password mot de passe
	 * @param encrypt_Password mot de passe hashe
	 * @return true si le mot de passe est correcte sinon false
	 */
    public boolean checkPassword(String password, String encrypt_Password) {
        return BCrypt.checkpw(password, encrypt_Password);
    }
}

package com.ticktrail.controllers;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.FxmlLoader;
import com.ticktrail.basic.Notification;
import com.ticktrail.basic.Password;
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
                Password checkPassword = new Password();
                if (checkPassword.checkPassword(password.getText(),
                        (String) user.get(email.getText()).get("password"))) {
                    user.login(email.getText());
                    FxmlLoader fxmlLoader = new FxmlLoader();
                    fxmlLoader.changePage("reservationPage", event);
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
}

package com.ticktrail.controllers;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.FxmlLoader;
import com.ticktrail.basic.Notification;
import com.ticktrail.basic.Pattern;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * classe decrivant l'enregistrement de l'utilisateur
 */
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
    TextField loc;

    @FXML
    TextField phone;

	/**
	 * Enregistrement de l'utilisateur
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnOnRegisterClicked(ActionEvent event) throws IOException {
        if (email != null) {
            User user = new User();
            if (!user.exist(email.getText())) {
                Pattern pattern = new Pattern();
                if (pattern.checkPassword(password.getText())) {
                    if (pattern.checkEmail(email.getText())) {
                        if (pattern.checkPhone(phone.getText())) {
                            if (pattern.checkLocation(loc.getText())) {
                                if (pattern.checkName(name.getText())) {
                                    if (pattern.checkSurname(surname.getText())) {
                                        if (password.getText().equals(confirm_password.getText())) {
                                            user.create(name.getText(), hashPassword(password.getText()),
                                                    surname.getText(),
                                                    phone.getText(),
                                                    email.getText(), loc.getText());
                                            user.login(email.getText());
                                            FxmlLoader fxmlLoader = new FxmlLoader();
                                            fxmlLoader.changePage("homePage", event);
                                            Notification notification = new Notification("Notification",
                                                    "Votre compte a été crée avec success.",
                                                    "success");
                                            notification.runNotification();
                                        }
                                    } else {
                                        Notification notification = new Notification("Erreur",
                                                "Merci de fournir votre vrai nom de famille.",
                                                "error");
                                        notification.runNotification();
                                    }
                                } else {
                                    Notification notification = new Notification("Erreur",
                                            "Merci de fournir votre vrai prénom.",
                                            "error");
                                    notification.runNotification();
                                }
                            } else {
                                Notification notification = new Notification("Erreur",
                                        "Merci de fournir un nom de ville valide.",
                                        "error");
                                notification.runNotification();
                            }
                        } else {
                            Notification notification = new Notification("Erreur",
                                    "Merci de fournir un numero de telephone valide.",
                                    "error");
                            notification.runNotification();
                        }
                    } else {
                        Notification notification = new Notification("Erreur",
                                "Merci de fournir un email valide.",
                                "error");
                        notification.runNotification();
                    }
                } else {
                    Notification notification = new Notification("Erreur",
                            "Merci de bien vouloir entrer un mot de passe avec des lettres et des chiffres au moins un caractere special et au moins une majuscule avec au minimum 5 caracteres et au maximum 20 caracteres.",
                            "error");
                    notification.runNotification();
                }
            } else {
                Notification notification = new Notification("Erreur", "Cet email est deja associé a un utilisateur.",
                        "error");
                notification.runNotification();
            }
        }
    }
	
	/**
	 * hashage du mot de passe
	 *
	 * @param password mot de passe a hasher
	 * @return le mot de passe hashe
	 */
    public String hashPassword(String password) {
        String passwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwd;
    }
}

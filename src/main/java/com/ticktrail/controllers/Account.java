package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.basic.Notification;
import com.ticktrail.basic.Password;
import com.ticktrail.basic.Pattern;
import com.ticktrail.database.Mysql;
import com.ticktrail.database.Storage;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * Classe decrivant les actions possibles sur le compte de l'utilisateur
 */
public class Account implements Initializable {
    @FXML
    TextField email;

    @FXML
    TextField password;

    @FXML
    TextField phone;

    @FXML
    TextField location;

    @FXML
    TextField name;

    @FXML
    TextField surname;

    /**
     * Mise a jour du compte utilisateur suite a un evenement
     *
     * @param event evenement
     * @throws IOException Si une erreur de lecture/ecriture arrive
     */
    @FXML
    void btnOnEditClicked(ActionEvent event) throws IOException {
        Mysql mysql = new Mysql();
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
        String token = storage.read_file();
        Pattern pattern = new Pattern();
        if (email.getText() != null) {
            if (pattern.checkEmail(email.getText())) {
                mysql.runQuery("UPDATE users SET email = \"" + email.getText() + "\" WHERE token = \"" + token + "\"");
            } else {
                Notification notification = new Notification("Erreur", "Merci de fournir une email valide.", "error");
                notification.runNotification();
            }
        }

        if (password.getText() != null) {
            if (pattern.checkPassword(password.getText())) {
                Password passwordHash = new Password();
                mysql.runQuery(
                        "UPDATE users SET password = \"" + passwordHash.hashPassword(password.getText())
                                + "\" WHERE token = \""
                                + token
                                + "\"");
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de bien vouloir entrer un mot de passe avec des lettres et des chiffres au moins un caractere special et au moins une majuscule avec au minimum 5 caracteres et au maximum 20 caracteres.",
                        "error");
                notification.runNotification();
            }
        }

        if (name.getText() != null) {
            if (pattern.checkName(name.getText())) {
                mysql.runQuery("UPDATE users SET name = \"" + name.getText() + "\" WHERE token = \"" + token + "\"");
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de fournir votre vrai prénom.",
                        "error");
                notification.runNotification();
            }
        }

        if (surname.getText() != null) {
            if (pattern.checkSurname(surname.getText())) {
                mysql.runQuery(
                        "UPDATE users SET surname = \"" + surname.getText() + "\" WHERE token = \"" + token + "\"");
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de fournir votre vrai nom de famille.",
                        "error");
                notification.runNotification();
            }
        }

        if (phone.getText() != null) {
            if (pattern.checkPhone(phone.getText())) {
                mysql.runQuery("UPDATE users SET phone = \"" + phone.getText() + "\" WHERE token = \"" + token + "\"");
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de fournir un numero de telephone valide.",
                        "error");
                notification.runNotification();
            }
        }

        if (location.getText() != null) {
            if (pattern.checkLocation(location.getText())) {
                mysql.runQuery(
                        "UPDATE users SET city = \"" + location.getText() + "\" WHERE token = \"" + token + "\"");
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de fournir un nom de ville valide.",
                        "error");
                notification.runNotification();
            }
        }
    }

    /**
     * initialise le compte de l'utilisateur
     *
     * @param url url
     * @param rb  resourcebundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User();
        try {
            email.setText(user.getWithToken().get("email").toString());
            phone.setText(user.getWithToken().get("phone").toString());
            location.setText(user.getWithToken().get("city").toString());
            name.setText(user.getWithToken().get("name").toString());
            surname.setText(user.getWithToken().get("surname").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import com.ticktrail.database.Mysql;
import com.ticktrail.database.Storage;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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

    @FXML
    void btnOnEditClicked(ActionEvent event) throws IOException {
        Mysql mysql = new Mysql();
        Storage storage = new Storage("./src/main/java/com/ticktrail/database/session.txt");
        String token = storage.read_file();

        if (email.getText() != null) {
            mysql.runQuery("UPDATE users SET email = \"" + email.getText() + "\" WHERE token = \"" + token + "\"");
        }

        if (password.getText() != null) {
            mysql.runQuery(
                    "UPDATE users SET password = \"" + hashPassword(password.getText()) + "\" WHERE token = \"" + token
                            + "\"");
        }

        if (name.getText() != null) {
            mysql.runQuery("UPDATE users SET name = \"" + name.getText() + "\" WHERE token = \"" + token + "\"");
        }

        if (surname.getText() != null) {
            mysql.runQuery("UPDATE users SET surname = \"" + surname.getText() + "\" WHERE token = \"" + token + "\"");
        }

        if (phone.getText() != null) {
            mysql.runQuery("UPDATE users SET phone = \"" + phone.getText() + "\" WHERE token = \"" + token + "\"");
        }

        if (location.getText() != null) {
            mysql.runQuery("UPDATE users SET city = \"" + location.getText() + "\" WHERE token = \"" + token + "\"");
        }
    }

    public String hashPassword(String password) {
        String passwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return passwd;
    }

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

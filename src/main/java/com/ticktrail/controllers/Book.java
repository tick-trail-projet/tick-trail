package com.ticktrail.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.ticktrail.FxmlLoader;
import com.ticktrail.basic.DateChecker;
import com.ticktrail.basic.Notification;
import com.ticktrail.database.Mysql;
import com.ticktrail.database.Storage;
import com.ticktrail.train.Cities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * classe decrivant les actions possibles sur la reservation
 */
public class Book {
    @FXML
    TextField from;

    @FXML
    TextField to;

    @FXML
    DatePicker date;

    /**
     * stockage de la reservation
     *
     * @param event evenement
     * @throws IOException Si une erreur de lecture/ecriture arrive
     */
    @FXML
    void btnBookNowClicked(ActionEvent event) throws IOException {
        if (from.getText() != null) {
            if (to.getText() != null) {
                if (date.getValue() != null) {
                    Mysql mysql = new Mysql();
                    Map<String, Object> city_from = mysql
                            .getSingleQuery("SELECT * FROM cities WHERE name LIKE \"%" + from.getText().toUpperCase()
                                    + "%\" LIMIT 1");
                    Map<String, Object> city_to = mysql
                            .getSingleQuery("SELECT * FROM cities WHERE name LIKE \"%" + to.getText().toUpperCase()
                                    + "%\" LIMIT 1");
                    if (city_from.get("name") != null) {
                        if (city_to.get("name") != null) {
                            if (!city_to.get("name").equals(city_from.get("name"))) {
                                DateChecker DateChecker = new DateChecker(date.getValue().toString());
                                if (DateChecker.isValid()) {
                                    Storage storage = new Storage("./src/main/java/com/ticktrail/database/trip.txt");
                                    storage.write_file(
                                            city_from.get("name").toString().toUpperCase() + ","
                                                    + city_to.get("name").toString().toUpperCase() + ","
                                                    + date.getValue());
                                    FxmlLoader fxmlLoader = new FxmlLoader();
                                    fxmlLoader.changePage("TrajetDisponiblePage", event);
                                } else {
                                    Notification notification = new Notification("Erreur",
                                            "Merci de fournir une date valide.",
                                            "error");
                                    notification.runNotification();
                                }
                            } else {
                                Notification notification = new Notification("Erreur",
                                        "Merci de fournir une ville differente.",
                                        "error");
                                notification.runNotification();
                            }
                        } else {
                            Notification notification = new Notification("Erreur",
                                    "Merci de fournir une ville d'arrivée ayant une gare.",
                                    "error");
                            notification.runNotification();
                        }
                    } else {
                        Notification notification = new Notification("Erreur",
                                "Merci de fournir une ville de départ ayant une gare.",
                                "error");
                        notification.runNotification();
                    }
                } else {
                    Notification notification = new Notification("Erreur",
                            "Merci de fournir une date valide.",
                            "error");
                    notification.runNotification();
                }
            } else {
                Notification notification = new Notification("Erreur",
                        "Merci de fournir une ville d'arrivée ayant une gare.",
                        "error");
                notification.runNotification();
            }
        } else {
            Notification notification = new Notification("Erreur",
                    "Merci de fournir une ville de départ ayant une gare.",
                    "error");
            notification.runNotification();
        }
    }

}

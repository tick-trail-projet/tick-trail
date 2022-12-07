package com.ticktrail.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ticktrail.FxmlLoader;
import com.ticktrail.database.Storage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Book {
    @FXML
    TextField from;

    @FXML
    TextField to;

    @FXML
    DatePicker date;

    @FXML
    void btnBookNowClicked(ActionEvent event) throws IOException {
        if (from.getText() != null) {
            if (to.getText() != null) {
                if (date.getValue() != null) {
                    Storage storage = new Storage("./src/main/java/com/ticktrail/database/trip.txt");
                    storage.write_file(from.getText() + "," + to.getText() + "," + date.getValue());
                    FxmlLoader fxmlLoader = new FxmlLoader();
                    fxmlLoader.changePage("TrajetDisponiblePage", event);
                }
            }
        }
    }

}

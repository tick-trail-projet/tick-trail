package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;

import com.ticktrail.App;
import com.ticktrail.FxmlLoader;
import com.ticktrail.stage.ControlledStage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Navbar {
    @FXML
    private BorderPane mainPane;

    @FXML
    void btnReserverClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("reservationPage", event);
    }

    @FXML
    void btnReservationsClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("MyReservationPage", event);
    }

    @FXML
    void btnParametresClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("paramsPage", event);
    }
}

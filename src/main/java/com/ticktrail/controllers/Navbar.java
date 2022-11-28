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
    void btnReserverClicked(ActionEvent event) {
        System.out.println("test");
    }

    @FXML
    void btnMesreservationsClicked(ActionEvent event) {
        System.out.println("test");
    }

    @FXML
    void btnParametresClicked(ActionEvent event) {
        System.out.println("test");
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("registerPage", event);
    }

    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("loginPage", event);
    }
}

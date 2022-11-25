package com.ticktrail.controllers;

import com.ticktrail.FxmlLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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
}

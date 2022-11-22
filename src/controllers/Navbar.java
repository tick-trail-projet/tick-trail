package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Navbar {

    @FXML
    private BorderPane mainPane;

    @FXML
    void btnReserverClicked(ActionEvent event) {
        System.out.println("test");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("test2");
        mainPane.setCenter(view);

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

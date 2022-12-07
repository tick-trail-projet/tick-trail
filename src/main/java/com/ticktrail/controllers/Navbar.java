package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ticktrail.App;
import com.ticktrail.FxmlLoader;
import com.ticktrail.stage.ControlledStage;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Navbar implements Initializable {
    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Button params;

    @FXML
    private Button reservations;

    @FXML
    private Button reserver;

    @FXML
    private Button logout;

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

    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("loginPage", event);
    }

    @FXML
    void btnRegisterClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("registerPage", event);
    }

    @FXML
    void btnLogoutClicked(ActionEvent event) throws IOException {
        User user = new User();
        user.logout();
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("homePage", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User();
        try {
            if (user.isLogin()) {
                register.setVisible(false);
                login.setVisible(false);
                logout.setVisible(true);
                params.setVisible(true);
                reserver.setVisible(true);
                reservations.setVisible(true);
            } else {
                register.setVisible(true);
                login.setVisible(true);
                logout.setVisible(false);
                params.setVisible(false);
                reserver.setVisible(false);
                reservations.setVisible(false);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

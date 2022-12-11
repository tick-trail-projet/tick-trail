package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ticktrail.FxmlLoader;
import com.ticktrail.basic.Notification;
import com.ticktrail.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * classe decrivant les actions possibles de l'utilisateur
 */
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
	
	/**
	 * reservation du trajet
	 *
	 * @param event evenemenent
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnReserverClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("reservationPage", event);
    }
	
	/**
	 * liste les reservations de l'utilisateur
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnReservationsClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("MyReservationPage", event);
    }
	
	/**
	 * liste les parametres
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnParametresClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("paramsPage", event);
    }
	
	/**
	 * connection de l'utilisateur
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("loginPage", event);
    }
	
	/**
	 * Enregistrement de l'utilisateur
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnRegisterClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("registerPage", event);
    }
	
	/**
	 * deconnection de l'utlisateur
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnLogoutClicked(ActionEvent event) throws IOException {
        User user = new User();
        user.logout();
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("homePage", event);
    }
	
	/**
	 * Gestion de la visibilte des boutons
	 *
	 * @param url url
	 * @param rb resourcebundle
	 */
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
            e.printStackTrace();
        }
    }
}

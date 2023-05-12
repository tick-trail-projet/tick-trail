package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ticktrail.FxmlLoader;
import com.ticktrail.database.Storage;
import com.ticktrail.train.Reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * classe decrivant les actions possibles sur la reservation
 */
public class EditReservation implements Initializable {
    @FXML
    TextField price;

    @FXML
    TextField from;

    @FXML
    TextField to;

    @FXML
    TextField from_schedule;

    @FXML
    TextField to_schedule;
	
	/**
	 * suppression de la reservation
	 *
	 * @param event evenement de suppression
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    void btnOnDeleteClicked(ActionEvent event) throws IOException {
        Reservation reservation = new Reservation();
        reservation.deleteReservation(from.getText(), to.getText(), Integer.parseInt(price.getText()),
                from_schedule.getText(), to_schedule.getText());
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("MyReservationPage", event);
    }
	
	/**
	 * initialisation de la reservation
	 *
	 * @param url url
	 * @param rb resourcebundle
	 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Storage storage = new Storage("./src/main/java/com/ticktrail/database/confirm.txt");
            price.setText(storage.read_file().split(",")[0]);
            from.setText(storage.read_file().split(",")[1]);
            to.setText(storage.read_file().split(",")[2]);
            from_schedule.setText(storage.read_file().split(",")[3]);
            to_schedule.setText(storage.read_file().split(",")[4]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

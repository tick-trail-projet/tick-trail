package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ticktrail.FxmlLoader;
import com.ticktrail.database.Storage;
import com.ticktrail.train.Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * classe decrivant la selection du train
 */
public class SelectTrain implements Initializable {
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
	 * Paiement du trajet
	 *
	 * @param event evenement
	 * @throws IOException probleme dans l'ecriture du fichier
	 */
    @FXML
    void btnOnPaidClicked(ActionEvent event) throws IOException {
        Book book = new Book();
        book.bookTrain(Integer.parseInt(price.getText()), from.getText(), to.getText(), from_schedule.getText(),
                to_schedule.getText());
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("MyReservationPage", event);
    }
	
	/**
	 * retour arriere
	 *
	 * @param event evenement
	 * @throws IOException probleme dans l'ecriture du fichier
	 */
    @FXML
    void btnOnBackClicked(ActionEvent event) throws IOException {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.changePage("TrajetDisponiblePage", event);
    }
	
	/**
	 * creation d'un trajet
	 *
	 * @param url utl
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

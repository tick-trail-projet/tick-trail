package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.ticktrail.FxmlLoader;
import com.ticktrail.database.Storage;
import com.ticktrail.train.Reservation;
import com.ticktrail.train.Trip;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * classe decrivant les actions possibles sur le choix de reservation de l'utilisateur
 */
public class MyReservations implements Initializable {

    @FXML
    private TableView<Trip> table;

    @FXML
    private TableColumn<Trip, String> price;

    @FXML
    private TableColumn<Trip, String> from;

    @FXML
    private TableColumn<Trip, String> to;

    @FXML
    private TableColumn<Trip, String> from_schedule;

    @FXML
    private TableColumn<Trip, String> to_schedule;
	
	/**
	 * AJout de la reservation de l'utilisateur dans sa liste
	 *
	 * @return la liste des reservations de l'utilisateur
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 * @throws SQLException probleme Bdd
	 */
    public ObservableList<Trip> tab() throws IOException, SQLException {
        Reservation reservation = new Reservation();
        return FXCollections.observableArrayList(
                reservation.MyReservation());
    }
	
	/**
	 * sauvegarde de la reservation
	 *
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    @FXML
    public void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 1) {
            if (table.getSelectionModel() != null) {
                Storage storage = new Storage("./src/main/java/com/ticktrail/database/confirm.txt");
                storage.write_file(
                        table.getSelectionModel().getSelectedItem().getPrice() + "," +
                                table.getSelectionModel().getSelectedItem().getFrom() + "," +
                                table.getSelectionModel().getSelectedItem().getTo() + "," +
                                table.getSelectionModel().getSelectedItem().getFrom_schedule() + "," +
                                table.getSelectionModel().getSelectedItem().getTo_schedule()

                );
                FxmlLoader fxmlLoader = new FxmlLoader();
                fxmlLoader.changePage("editReservation", event);
            }
        }
    }
	
	/**
	 * creation de la reservation de l'utilisateur
	 * @param url url
	 * @param rb resourcebundle
	 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        from.setCellValueFactory(new PropertyValueFactory<Trip, String>("from"));
        to.setCellValueFactory(new PropertyValueFactory<Trip, String>("to"));
        price.setCellValueFactory(new PropertyValueFactory<Trip, String>("price"));
        from_schedule.setCellValueFactory(new PropertyValueFactory<Trip, String>("from_schedule"));
        to_schedule.setCellValueFactory(new PropertyValueFactory<Trip, String>("to_schedule"));
        try {
            table.setItems(tab());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

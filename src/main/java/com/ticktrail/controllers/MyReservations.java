package com.ticktrail.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public ObservableList<Trip> tab() throws IOException, SQLException {
        Reservation reservation = new Reservation();
        return FXCollections.observableArrayList(
                reservation.MyReservation());
    }

    @FXML
    public void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 1) {
            FxmlLoader fxmlLoader = new FxmlLoader();
            fxmlLoader.changePage("editReservation", event);
        }
    }

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

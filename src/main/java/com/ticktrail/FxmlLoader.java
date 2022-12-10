package com.ticktrail;

import java.io.IOException;
import java.net.URL;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Gestion du chargement du Fxml
 */
public class FxmlLoader {

    private Pane view;
	
	/**
	 * retourne la page
	 * @param fileName nom de la page
	 * @return la vue
	 */
    public Pane getPage(String fileName) {
        try {
            URL fileUrl = App.class.getResource("/pages/" + fileName + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }

            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("This page doesn't exist please check /pages/ folder");
        }
        return view;
    }
	
	/**
	 * change de page
	 * @param fileName nom de la page
	 * @param event evenement
	 * @throws IOException Si une erreur de lecture/ecriture arrive
	 */
    public void changePage(String fileName, Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pages/" + fileName + ".fxml"));
        root.getStylesheets().add(getClass().getResource("public/css/style.css").toExternalForm());
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}

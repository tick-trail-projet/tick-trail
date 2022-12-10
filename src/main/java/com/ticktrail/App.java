package com.ticktrail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * classe principale de lancement de l'application
 */
public class App extends Application {
	
	/**
	 * Demarrage de l'application
	 * @param primaryStage
	 * @throws Exception
	 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pages/HomePage.fxml"));
        root.getStylesheets().add(getClass().getResource("public/css/style.css").toExternalForm());
        primaryStage.setTitle("Tick&Trail");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

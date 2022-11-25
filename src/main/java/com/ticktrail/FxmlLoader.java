package com.ticktrail;

import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class FxmlLoader {

    private Pane view;

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
}

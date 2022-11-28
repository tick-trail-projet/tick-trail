package com.ticktrail.stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import com.ticktrail.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControlledStage {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();;

    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
    }

    public void addPrimaryStage(Stage primaryStage) {
        this.addStage("primaryStage", primaryStage);
    }

    public Stage getPrimaryStage() {
        return stages.get("primaryStage");
    }

    public Stage getStage(String name) {
        return stages.get(name);
    }

    public void loadStage(String name) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../pages/" + name + ".fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.NONE);
            this.addStage(name, stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean unloadStage(String name) {
        if (stages.remove(name) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean showStage(String name) {
        this.getStage(name).show();
        return true;
    }

    public boolean switchStage(String show, String close) {
        closeStage(close);
        this.getStage(show).show();
        return true;
    }

    public boolean switchStage2(String name, String new_scene) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../pages/" + new_scene + ".fxml"));
        Scene scene = new Scene(root);
        this.getStage(name).setScene(scene);
        return true;
    }

    public boolean closeStage(String name) {
        getStage(name).close();
        return true;
    }

    public boolean isShowingStage(String name) {
        if (getStage(name).isShowing()) {
            return true;
        } else {
            return false;
        }
    }

}

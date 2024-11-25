package com.project.textprocessingtool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("MainUI.fxml"));

        // Create the scene
        Scene scene = new Scene(loader.load());

        // Set the stage
        stage.setTitle("Text Processing Tool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

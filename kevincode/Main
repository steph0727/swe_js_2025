package com.example.j_25;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create waiter selection UI components
        Label waiterLabel = new Label("Select Your Waiter:");
        Button waiter1 = new Button("Waiter 1");
        Button waiter2 = new Button("Waiter 2");
        Button waiter3 = new Button("Waiter 3");

        // Set actions for each waiter button
        waiter1.setOnAction(e -> loadWaiterScene(primaryStage, "waiter1.fxml"));
        waiter2.setOnAction(e -> loadWaiterScene(primaryStage, "waiter2.fxml"));
        waiter3.setOnAction(e -> loadWaiterScene(primaryStage, "waiter3.fxml"));

        // Layout setup
        VBox waiterLayout = new VBox(10, waiterLabel, waiter1, waiter2, waiter3);
        waiterLayout.setAlignment(javafx.geometry.Pos.CENTER);
        waiterLayout.setPadding(new javafx.geometry.Insets(20));

        // Set primary stage properties
        primaryStage.setTitle("J's Restaurant");
        primaryStage.setScene(new Scene(waiterLayout, 300, 200));
        primaryStage.show();
    }

    private void loadWaiterScene(Stage stage, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            stage.setScene(new Scene(root, 550, 250));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.j_25;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    private Button selectedButton;
    private boolean guestSelected = false;

    @FXML
    private void TableGuests(javafx.event.ActionEvent event) {
        selectedButton = (Button) event.getSource();
        String currentColor = getColor(selectedButton);

        if (currentColor.equals("green")) {
            handleNewTable();
        } else if (currentColor.equals("yellow")) {
            handleExistingTable();
        } else if (currentColor.equals("red")) {
            handleDirtyTable();
        }
    }

    private String getColor(Button button) {
        String style = button.getStyle();
        if (style.contains("green")) return "green";
        if (style.contains("yellow")) return "yellow";
        if (style.contains("red")) return "red";
        return "unknown";
    }

    private void handleNewTable() {
        guestSelected = false;

        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        Label message = new Label("Guests!");

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button close = new Button("Close");

        one.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: yellow;");
            guestSelected = true;
            popup.close();
        });
        two.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: yellow;");
            guestSelected = true;
            popup.close();
        });
        three.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: yellow;");
            guestSelected = true;
            popup.close();
        });
        four.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: yellow;");
            guestSelected = true;
            popup.close();
        });

        close.setOnAction(e -> popup.close());

        VBox layout = new VBox(10, message, one, two, three, four, close);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene popupScene = new Scene(layout, 500, 300);
        popup.setScene(popupScene);

        popup.setOnHidden(e -> {
            if (guestSelected) {
                Menu();
            }
        });

        popup.showAndWait();
    }

    private void handleExistingTable() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        Label message = new Label("This table is occupied.");

        Button order = new Button("Put in Order");
        Button dirty = new Button("Mark as Dirty");
        Button close = new Button("Cancel");

        order.setOnAction(e -> {
            popup.close();
            Menu();
        });

        dirty.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: red;");
            popup.close();
        });

        close.setOnAction(e -> popup.close());

        VBox layout = new VBox(10, message, order, dirty, close);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        popup.setScene(new Scene(layout, 400, 200));
        popup.showAndWait();
    }

    private void handleDirtyTable() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        Label message = new Label("This table is dirty.");

        Button clean = new Button("Mark as Clean");
        Button cancel = new Button("Cancel");

        clean.setOnAction(e -> {
            selectedButton.setStyle("-fx-background-color: green;");
            popup.close();
        });

        cancel.setOnAction(e -> popup.close());

        VBox layout = new VBox(10, message, clean, cancel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        popup.setScene(new Scene(layout, 400, 200));
        popup.showAndWait();
    }


    private void Menu() {
        Stage food = new Stage();
        food.initModality(Modality.APPLICATION_MODAL);
        Label appetizers = new Label("Appetizers");
        Button app1 = new Button("Cheese Sticks");
        Button app2 = new Button("Calamari");
        Button app3 = new Button("Queso Dip");
        Button app4 = new Button("Fried Pickles");
        VBox appItems = new VBox((double)10.0F, new Node[]{appetizers, app1, app2, app3, app4});
        Label salads = new Label("Salads");
        Button sal1 = new Button("Caesar");
        Button sal2 = new Button("Greek");
        Button sal3 = new Button("J's");
        Button sal4 = new Button("Strawberry Pecan");
        VBox saladItems = new VBox((double)10.0F, new Node[]{salads, sal1, sal2, sal3, sal4});
        Label entrees = new Label("Entrees");
        Button ent1 = new Button("NY Strip");
        Button ent2 = new Button("Burger");
        Button ent3 = new Button("Salmon BLT");
        Button ent4 = new Button("Chicken Parmesan");
        Button closeMenu = new Button("Close");
        VBox entreeItems = new VBox((double)10.0F, new Node[]{entrees, ent1, ent2, ent3, ent4, closeMenu});
        Label sides = new Label("Sides");
        Button side1 = new Button("Mac N Cheese");
        Button side2 = new Button("French Fries");
        Button side3 = new Button("Mashed Potatoes");
        Button side4 = new Button("Broccoli");
        VBox sideItems = new VBox((double)10.0F, new Node[]{sides, side1, side2, side3, side4});
        Label drinks = new Label("Drinks");
        Button dr1 = new Button("Lemonade");
        Button dr2 = new Button("Sprite");
        Button dr3 = new Button("Coke");
        Button dr4 = new Button("Orange Juice");
        VBox drinkItems = new VBox((double)10.0F, new Node[]{drinks, dr1, dr2, dr3, dr4});
        closeMenu.setOnAction((e) -> food.close());
        HBox foodItems = new HBox((double)10.0F, new Node[]{appItems, saladItems, entreeItems, sideItems, drinkItems});
        foodItems.setAlignment(Pos.CENTER);
        foodItems.setPadding(new Insets((double)20.0F));
        food.setScene(new Scene(foodItems, (double)800.0F, (double)300.0F));
        food.showAndWait();
    }
}

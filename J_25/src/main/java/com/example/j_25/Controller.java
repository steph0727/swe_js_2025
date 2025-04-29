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
import java.util.*;
import java.util.ArrayList;

public class Controller {
    private Button selectedButton;
    private boolean guestSelected = false;
    private Button createFoodButton(String name, List<String> selectedItems) {
        Button button = new Button(name);
        button.setOnAction(e -> selectedItems.add(name));
        return button;
    }

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
        List<String> selectedItems = new ArrayList<>();
        Stage food = new Stage();
        food.initModality(Modality.APPLICATION_MODAL);
        Label appetizers = new Label("Appetizers");
        // Appetizers
        Button app1 = createFoodButton("Cheese Sticks", selectedItems);
        Button app2 = createFoodButton("Calamari", selectedItems);
        Button app3 = createFoodButton("Queso Dip", selectedItems);
        Button app4 = createFoodButton("Fried Pickles", selectedItems);
        VBox appItems = new VBox((double)10.0F, new Node[]{appetizers, app1, app2, app3, app4});
        Label salads = new Label("Salads");
        // Salads
        Button sal1 = createFoodButton("Caesar", selectedItems);
        Button sal2 = createFoodButton("Greek", selectedItems);
        Button sal3 = createFoodButton("J's", selectedItems);
        Button sal4 = createFoodButton("Strawberry Pecan", selectedItems);
        VBox saladItems = new VBox((double)10.0F, new Node[]{salads, sal1, sal2, sal3, sal4});
        Label entrees = new Label("Entrees");
        // Entrees
        Button ent1 = createFoodButton("NY Strip", selectedItems);
        Button ent2 = createFoodButton("Burger", selectedItems);
        Button ent3 = createFoodButton("Salmon BLT", selectedItems);
        Button ent4 = createFoodButton("Chicken Parmesan", selectedItems);
        Button closeMenu = new Button("Close");
        VBox entreeItems = new VBox((double)10.0F, new Node[]{entrees, ent1, ent2, ent3, ent4, closeMenu});
        Label sides = new Label("Sides");
        // Sides
        Button side1 = createFoodButton("Mac N Cheese", selectedItems);
        Button side2 = createFoodButton("French Fries", selectedItems);
        Button side3 = createFoodButton("Mashed Potatoes", selectedItems);
        Button side4 = createFoodButton("Broccoli", selectedItems);
        VBox sideItems = new VBox((double)10.0F, new Node[]{sides, side1, side2, side3, side4});
        Label drinks = new Label("Drinks");
        // Drinks
        Button dr1 = createFoodButton("Lemonade", selectedItems);
        Button dr2 = createFoodButton("Sprite", selectedItems);
        Button dr3 = createFoodButton("Coke", selectedItems);
        Button dr4 = createFoodButton("Orange Juice", selectedItems);
        VBox drinkItems = new VBox((double)10.0F, new Node[]{drinks, dr1, dr2, dr3, dr4});
        closeMenu.setOnAction((e) -> {
            if (!selectedItems.isEmpty()) {
                Order order = new Order(selectedButton.getText(), selectedItems);
                OrderQueue.addOrder(order);
            }
            food.close();
        });
        HBox foodItems = new HBox((double)10.0F, new Node[]{appItems, saladItems, entreeItems, sideItems, drinkItems});
        foodItems.setAlignment(Pos.CENTER);
        foodItems.setPadding(new Insets((double)20.0F));
        food.setScene(new Scene(foodItems, (double)800.0F, (double)300.0F));
        food.showAndWait();
    }
}

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

    //Method for font style
    private void setFontStyle(Node node) {
        if (node instanceof Label) {
            ((Label) node).setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        } else if (node instanceof Button) {
            ((Button) node).setStyle("-fx-font-size: 14px; -fx-font-weight: normal;");
        }
    }

    private Button createFoodButton(String name, List<String> selectedItems) {
        Button button = new Button(name);
        button.setOnAction(e -> selectedItems.add(name));
        setFontStyle(button);
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
        popup.setTitle("Guest Selection");

        Label message = new Label("How many guests?");
        setFontStyle(message);

        //Buttons
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button close = new Button("Cancel");

        List<Button> buttons = Arrays.asList(one, two, three, four, close);
        for (Button b : buttons) {
            b.setPrefWidth(100);
            setFontStyle(b);
        }

        one.setOnAction(e -> seatGuests(popup));
        two.setOnAction(e -> seatGuests(popup));
        three.setOnAction(e -> seatGuests(popup));
        four.setOnAction( e-> seatGuests(popup));
        close.setOnAction(e -> popup.close());

        //Layout
        HBox guestButtons = new HBox(10, message, one, two, three, four);
        guestButtons.setAlignment(Pos.CENTER);
        VBox layout = new VBox(15, message, guestButtons, close);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Scene popupScene = new Scene(layout, 500, 300);
        popup.setScene(popupScene);

        popup.setOnHidden(e -> {
            if (guestSelected) {
                handleExistingTable();
            }
        });

        popup.showAndWait();
    }

    private void seatGuests(Stage popup) {
        selectedButton.setStyle("-fx-background-color: yellow;");
        guestSelected = true;
        popup.close();
    }

    private void handleExistingTable() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);

        Label message = new Label("This table is occupied.");
        setFontStyle(message);

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
        setFontStyle(message);

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
        food.setTitle("Menu Selection");

        Label appetizers = new Label("Appetizers");
        setFontStyle(appetizers);
        Label salads = new Label("Salads");
        setFontStyle(salads);
        Label entrees = new Label("Entrees");
        setFontStyle(entrees);
        Label sides = new Label("Sides");
        setFontStyle(sides);
        Label drinks = new Label("Drinks");
        setFontStyle(drinks);

        // Appetizers
        Button app1 = createFoodButton("Cheese Sticks", selectedItems);
        Button app2 = createFoodButton("Calamari", selectedItems);
        Button app3 = createFoodButton("Queso Dip", selectedItems);
        Button app4 = createFoodButton("Fried Pickles", selectedItems);
        VBox appItems = new VBox(10,appetizers, app1, app2, app3, app4);

        // Salads
        Button sal1 = createFoodButton("Caesar", selectedItems);
        Button sal2 = createFoodButton("Greek", selectedItems);
        Button sal3 = createFoodButton("J's", selectedItems);
        Button sal4 = createFoodButton("Strawberry Pecan", selectedItems);
        VBox saladItems = new VBox(10, salads, sal1, sal2, sal3, sal4);

        // Entrees
        Button ent1 = createFoodButton("NY Strip", selectedItems);
        Button ent2 = createFoodButton("Burger", selectedItems);
        Button ent3 = createFoodButton("Salmon BLT", selectedItems);
        Button ent4 = createFoodButton("Chicken Parmesan", selectedItems);
        Button closeMenu = new Button("Close");
        VBox entreeItems = new VBox(10, entrees, ent1, ent2, ent3, ent4, closeMenu);

        // Sides
        Button side1 = createFoodButton("Mac N Cheese", selectedItems);
        Button side2 = createFoodButton("French Fries", selectedItems);
        Button side3 = createFoodButton("Mashed Potatoes", selectedItems);
        Button side4 = createFoodButton("Broccoli", selectedItems);
        VBox sideItems = new VBox(10, sides, side1, side2, side3, side4);

        // Drinks
        Button dr1 = createFoodButton("Lemonade", selectedItems);
        Button dr2 = createFoodButton("Sprite", selectedItems);
        Button dr3 = createFoodButton("Coke", selectedItems);
        Button dr4 = createFoodButton("Orange Juice", selectedItems);
        VBox drinkItems = new VBox(10, drinks, dr1, dr2, dr3, dr4);
        closeMenu.setOnAction((e) -> {
            if (!selectedItems.isEmpty()) {
                Order order = new Order(selectedButton.getText(), selectedItems);
                OrderQueue.addOrder(order);
            }
            food.close();
        });

        HBox foodItems = new HBox(10.0, appItems, saladItems, entreeItems, sideItems, drinkItems);
        foodItems.setAlignment(Pos.CENTER);
        foodItems.setPadding(new Insets(20));
        food.setScene(new Scene(foodItems, 800, 300));
        food.show();
    }
}

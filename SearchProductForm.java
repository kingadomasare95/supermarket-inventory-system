package com.supermarket.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchProductForm {

    private Inventory inventory;

    public SearchProductForm(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show(Stage stage) {

        Label title = new Label("Search Product");

        TextField searchField = new TextField();
        searchField.setPromptText("Enter Product ID");

        Button searchBtn = new Button("Search");
        Label result = new Label();

        searchBtn.setOnAction(e -> {

            try {
                int id = Integer.parseInt(searchField.getText());

                Product product = inventory.searchProduct(id);

                if (product != null) {
                    result.setText(
                            "Name: " + product.getProductName() +
                                    "\nCategory: " + product.getCategory() +
                                    "\nPrice: " + product.getPrice() +
                                    "\nQuantity: " + product.getQuantity()
                    );
                } else {
                    result.setText("Product not found!");
                }

            } catch (Exception ex) {
                result.setText("Enter a valid numeric ID!");
            }
        });

        VBox root = new VBox(10, title, searchField, searchBtn, result);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Search Product");
        stage.setScene(scene);
        stage.show();
    }
}
package com.supermarket.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateProductForm {

    private Inventory inventory;

    public UpdateProductForm(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show(Stage stage) {

        Label title = new Label("Update Product");

        TextField idField = new TextField();
        idField.setPromptText("Product ID");

        TextField nameField = new TextField();
        TextField categoryField = new TextField();
        TextField priceField = new TextField();
        TextField qtyField = new TextField();
        TextField supplierField = new TextField();

        Button updateBtn = new Button("Update");
        Label message = new Label();

        updateBtn.setOnAction(e -> {

            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String category = categoryField.getText();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(qtyField.getText());
                String supplier = supplierField.getText();

                boolean updated = inventory.updateProduct(id, name, category, price, qty, supplier);

                if (updated) {
                    message.setText("Product updated successfully!");
                } else {
                    message.setText("Product not found!");
                }

            } catch (Exception ex) {
                message.setText("Invalid input!");
            }
        });

        VBox root = new VBox(10,
                title,
                idField,
                nameField,
                categoryField,
                priceField,
                qtyField,
                supplierField,
                updateBtn,
                message
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 350, 350);

        stage.setTitle("Update Product");
        stage.setScene(scene);
        stage.show();
    }
}
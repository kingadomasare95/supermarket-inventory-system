package com.supermarket.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddProductForm {

    private Inventory inventory;
    private Stage dashboardStage;

    public AddProductForm(Inventory inventory, Stage dashboardStage) {
        this.inventory = inventory;
        this.dashboardStage = dashboardStage;
    }

    public void show() {

        Stage stage = new Stage();

        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField categoryField = new TextField();
        TextField priceField = new TextField();
        TextField qtyField = new TextField();
        TextField supplierField = new TextField();

        Button saveBtn = new Button("Save");
        Button backBtn = new Button("Back to Dashboard");

        Label message = new Label();

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("ID"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Name"), 0, 1);
        grid.add(nameField, 1, 1);

        grid.add(new Label("Category"), 0, 2);
        grid.add(categoryField, 1, 2);

        grid.add(new Label("Price"), 0, 3);
        grid.add(priceField, 1, 3);

        grid.add(new Label("Quantity"), 0, 4);
        grid.add(qtyField, 1, 4);

        grid.add(new Label("Supplier"), 0, 5);
        grid.add(supplierField, 1, 5);

        grid.add(saveBtn, 1, 6);
        grid.add(backBtn, 1, 7);

        VBox root = new VBox(10, grid, message);
        root.setPadding(new Insets(20));

        // Save Product
        saveBtn.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String category = categoryField.getText();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(qtyField.getText());
                String supplier = supplierField.getText();

                Product product = new Product(id, name, category, price, qty, supplier);
                inventory.addProduct(product);

                message.setStyle("-fx-text-fill: green;");
                message.setText("Product added successfully!");

                // Clear the fields for the next product
                idField.clear();
                nameField.clear();
                categoryField.clear();
                priceField.clear();
                qtyField.clear();
                supplierField.clear();

                // Put the cursor back in the first field
                idField.requestFocus();

            } catch (Exception ex) {
                message.setStyle("-fx-text-fill: red;");
                message.setText("Invalid input!");
            }
        });
        // Back Button
        backBtn.setOnAction(e -> {
            stage.close();
            dashboardStage.show();
        });

        Scene scene = new Scene(root, 400, 450);

        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }
}
package com.supermarket.model;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteProductForm {

    private Inventory inventory;

    public DeleteProductForm(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show(Stage stage) {

        Label title = new Label("Delete Product");

        TextField idField = new TextField();
        idField.setPromptText("Enter Product ID");

        Button deleteBtn = new Button("Delete");
        Label message = new Label();

        deleteBtn.setOnAction(e -> {

            try {
                int id = Integer.parseInt(idField.getText());

                boolean deleted = inventory.deleteProduct(id);

                if (deleted) {
                    message.setText("Product deleted successfully!");
                } else {
                    message.setText("Product not found!");
                }

            } catch (Exception ex) {
                message.setText("Enter a valid numeric ID!");
            }
        });

        VBox root = new VBox(10, title, idField, deleteBtn, message);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Delete Product");
        stage.setScene(scene);
        stage.show();
    }
}
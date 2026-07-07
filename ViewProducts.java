package com.supermarket.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewProducts {

    private Inventory inventory;

    public ViewProducts(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show(Stage stage) {

        TableView<Product> table = new TableView<>();

        TableColumn<Product, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("productId"));

        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Product, String> catCol = new TableColumn<>("Category");
        catCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Product, String> supCol = new TableColumn<>("Supplier");
        supCol.setCellValueFactory(new PropertyValueFactory<>("supplier"));

        table.getColumns().addAll(idCol, nameCol, catCol, priceCol, qtyCol, supCol);

        ObservableList<Product> data =
                FXCollections.observableArrayList(inventory.getAllProducts());

        table.setItems(data);

        VBox root = new VBox(table);

        Scene scene = new Scene(root, 700, 400);

        stage.setTitle("View Products");
        stage.setScene(scene);
        stage.show();
    }
}
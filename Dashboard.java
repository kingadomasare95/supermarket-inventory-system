package com.supermarket;

import com.supermarket.model.AddProductForm;
import com.supermarket.model.Inventory;
import com.supermarket.model.ViewProducts;
import com.supermarket.model.SearchProductForm;
import com.supermarket.model.DeleteProductForm;
import com.supermarket.model.UpdateProductForm;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard {

    private BorderPane root;
    private VBox centerArea;
    private Inventory inventory = new Inventory();

    private void setCenter(Region node) {
        root.setCenter(node);
    }

    public void show(Stage stage) {

        //  ROOT INIT
        root = new BorderPane();

        //  SIDEBAR
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(20));
        sidebar.setPrefWidth(220);
        sidebar.setMinWidth(220);

        sidebar.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #2E7D32, #1B5E20);" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 2);"
        );

        Label menuTitle = new Label("MENU");
        menuTitle.setStyle(
                "-fx-text-fill:white;" +
                        "-fx-font-size:16px;" +
                        "-fx-font-weight:bold;"
        );

        Button addBtn = new Button("Add Product");
        Button viewBtn = new Button("View Products");
        Button searchBtn = new Button("Search Product");
        Button deleteBtn = new Button("Delete Product");
        Button updateBtn = new Button("Update Product");
        Button logoutBtn = new Button("Logout");

        Button[] buttons = {addBtn, viewBtn, searchBtn, deleteBtn, updateBtn, logoutBtn};

        for (Button btn : buttons) {
            btn.setMaxWidth(Double.MAX_VALUE);

            btn.setStyle(
                    "-fx-background-color:rgba(255,255,255,0.15);" +
                            "-fx-text-fill:white;" +
                            "-fx-font-size:14px;" +
                            "-fx-alignment: CENTER_LEFT;" +
                            "-fx-padding:10 15 10 15;" +
                            "-fx-background-radius:6;" +
                            "-fx-cursor:hand;"
            );

            btn.setOnMouseEntered(e ->
                    btn.setStyle(
                            "-fx-background-color:rgba(255,255,255,0.25);" +
                                    "-fx-text-fill:white;" +
                                    "-fx-font-size:14px;" +
                                    "-fx-padding:10 15 10 15;" +
                                    "-fx-background-radius:6;"
                    )
            );

            btn.setOnMouseExited(e ->
                    btn.setStyle(
                            "-fx-background-color:rgba(255,255,255,0.15);" +
                                    "-fx-text-fill:white;" +
                                    "-fx-font-size:14px;" +
                                    "-fx-padding:10 15 10 15;"
                    )
            );
        }

        sidebar.getChildren().addAll(menuTitle, addBtn, viewBtn, searchBtn, deleteBtn, updateBtn, logoutBtn);

        // ================= HEADER
        Label header = new Label("Supermarket Inventory Dashboard");
        header.setStyle(
                "-fx-font-size:22px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-text-fill:#2E7D32;"
        );

        VBox topBar = new VBox(header);
        topBar.setPadding(new Insets(15));
        topBar.setStyle(
                "-fx-background-color:#F8F9FA;" +
                        "-fx-border-color:#E0E0E0;" +
                        "-fx-border-width:0 0 1 0;"
        );

        // ================= CENTER AREA
        centerArea = new VBox(20);
        centerArea.setPadding(new Insets(20));

        Label welcome = new Label("Welcome, Admin");
        welcome.setStyle(
                "-fx-font-size:24px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-text-fill:#2E7D32;"
        );

        Label subtitle = new Label("Select an option from the menu to continue");
        subtitle.setStyle(
                "-fx-font-size:14px;" +
                        "-fx-text-fill:#777;"
        );

        centerArea.getChildren().addAll(welcome, subtitle);

        // LAYOUT
        root.setLeft(sidebar);
        root.setTop(topBar);
        root.setCenter(centerArea);

        // ACTIONS
        addBtn.setOnAction(e -> {
            stage.hide(); // Hide the dashboard
            new AddProductForm(inventory, stage).show();
        });
        viewBtn.setOnAction(e -> new ViewProducts(inventory).show(stage));
        searchBtn.setOnAction(e -> new SearchProductForm(inventory).show(stage));
        deleteBtn.setOnAction(e -> new DeleteProductForm(inventory).show(stage));
        updateBtn.setOnAction(e -> new UpdateProductForm(inventory).show(stage));
        logoutBtn.setOnAction(e -> stage.close());

        // ================= SCENE =================
        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
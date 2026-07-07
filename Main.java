package com.supermarket;

import com.supermarket.auth.LoginForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        LoginForm login = new LoginForm();

        Scene scene = login.createLoginScene();

        stage.setTitle("Supermarket Inventory Management System");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
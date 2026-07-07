package com.supermarket.auth;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.supermarket.Dashboard;
import javafx.stage.Stage;

public class LoginForm {

    private TextField emailField;
    private PasswordField passwordField;
    private CheckBox rememberMe;

    public Scene createLoginScene() {

        Label title = new Label("SUPERMARKET INVENTORY SYSTEM");
        title.setStyle("-fx-font-size:24px; -fx-font-weight:bold; -fx-text-fill:#2E7D32;");

        Label subtitle = new Label("Welcome Back");
        subtitle.setStyle("-fx-font-size:16px;");

        emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setPrefWidth(500);
        emailField.setMaxWidth(500);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefWidth(500);
        passwordField.setMaxWidth(500);
        emailField.setStyle(
                "-fx-background-radius:8;" +
                        "-fx-border-radius:8;"
        );

        passwordField.setStyle(
                "-fx-background-radius:8;" +
                        "-fx-border-radius:8;"
        );

        rememberMe = new CheckBox("Remember Me");

        Button loginButton = new Button("Sign In");
        loginButton.setPrefWidth(250);
        loginButton.setOnAction(e -> {

            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            if (email.equals("admin@gmail.com") && password.equals("1234")) {

                Stage stage = (Stage) loginButton.getScene().getWindow();

                Dashboard dashboard = new Dashboard();

                dashboard.show(stage);

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email or password.");
                alert.showAndWait();

            }

        });

        Button signupButton = new Button("Sign Up");

        Hyperlink forgotPassword = new Hyperlink("Forgot Password?");

        VBox root = new VBox(15);

        root.getChildren().addAll(
                title,
                subtitle,
                emailField,
                passwordField,
                rememberMe,
                loginButton,
                forgotPassword,
                signupButton
        );

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.setStyle(
                "-fx-background-color:#F8F9FA;"
        );

        loginButton.setStyle(
                "-fx-background-color:#2E7D32;" +
                        "-fx-text-fill:white;" +
                        "-fx-font-size:14px;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:8;" +
                        "-fx-cursor:hand;"
        );

        Scene scene = new Scene(root, 500, 600);

        return scene;
    }
}
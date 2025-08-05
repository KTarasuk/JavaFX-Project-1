package dev.ktarasuk.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = new StackPane();

        Label label = new Label();
        label.setText("JavaFX App");
        label.setStyle( "-fx-text-fill: #FFFFFF;\n" +
                        "-fx-font-size: 64;");

        Button btnExit = new Button();
        StackPane.setMargin(btnExit, new Insets(0,0,500,680));
        btnExit.setText("X");
        btnExit.setPadding(new Insets(10,10,10,10));
        btnExit.setStyle(   "-fx-background-color: red;\n" +
                        "-fx-text-fill: #FFFFFF;");
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        root.getChildren().addAll(btnExit, label);

        root.setStyle(  "-fx-background-color: rgb(45, 45, 50), rgb(60, 60, 65);\n" +
                        "-fx-background-insets: 0, 0 1 1 0;\n" +
                        "-fx-border-radius: 20;\n" +
                        "-fx-background-radius: 20;");
        Scene scene = new Scene(root, 720, 560, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        // ПЕРЕДВИЖЕНИЕ ОКНА
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

}
package org.escuela.escuelacompleto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AplicacionEscuela extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicacionEscuela.class.getResource("/org/escuela/escuelacompleto/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);

        scene.getStylesheets().add(AplicacionEscuela.class.getResource("/org/escuela/escuelacompleto/estilos/estilos-generales.css").toExternalForm());

        stage.setTitle("INGRESA A TU USUARIO!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package org.escuela.escuelacompleto.Controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.escuela.escuelacompleto.AplicacionEscuela;

import javax.swing.*;

public class loginControlador {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private void verificacionContrasenia(){
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        if (usuario.equals("") || contrasenia.equals("")){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AplicacionEscuela.class.getResource("/org/escuela/escuelacompleto/administrador.fxml"));
            AnchorPane root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setTitle("ADMINISTRADOR");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar el administrador" + e.getMessage());
        }

        }else if (usuario.equals("maestro") && contrasenia.equals("maestro")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(AplicacionEscuela.class.getResource("/org/escuela/escuelacompleto/maestros.fxml"));
                AnchorPane root = fxmlLoader.load();


                Scene scene = new Scene(root);
                scene.getStylesheets().add(AplicacionEscuela.class.getResource("/org/escuela/escuelacompleto/estilos/estilos-generales.css").toExternalForm());
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.setTitle("MAESTROS");
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar el maestro");
            }
        }
    }


}

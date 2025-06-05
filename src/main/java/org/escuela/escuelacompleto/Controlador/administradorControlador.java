package org.escuela.escuelacompleto.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.escuela.escuelacompleto.Modelo.cursosModelo;
import org.escuela.escuelacompleto.Modelo.duracionCursosModelo;
import org.escuela.escuelacompleto.Modelo.personaModelo;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class administradorControlador implements Initializable {


    @FXML
    private DatePicker fechaInicio, fechaFinal, fechaCreacionUsuario;

    @FXML
    private SplitMenuButton splitUsuarios;

    @FXML
    private TextField txtNombreCreacion, txtContraseniaCreacion, txtEmailCreacion, txtTelefonoCreacion, txtEliminarUsuarios, txtIdMaestro, txtNombreCurso;

    @FXML
    private TableView<personaModelo> tablaBuscarUsuasrios, tablaMaestros;

    @FXML
    private TableView<cursosModelo> tablaCursos;

    @FXML
    private TableColumn<personaModelo, Integer> columnaId, idColumnaMaestros;

    @FXML
    private TableColumn<personaModelo, String> columnaNombre, columnaTipoUsuario, columnaEmail, columnaTelefono, columnaNombreMaestros;

    @FXML
    private Button btnEliminar, btnBuscarPersona, btnMaestros, btnCrearCurso;


    @FXML
    public void opcionAdministrador(){
        splitUsuarios.setText("administrador");
    }

    @FXML
    public void opcionAlumno(){
        splitUsuarios.setText("alumno");
    }

    @FXML
    public void opcionMaestro(){
        splitUsuarios.setText("maestro");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seteoFechas();
        setearTamañoSplit();

        CargarDatos();
        cargarMaestros();
    }

    public void CargarDatos(){
        columnaId.setCellValueFactory(new PropertyValueFactory<>("idUsuarios"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        columnaTipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        List<personaModelo> listaPersonas = personaModelo.listarTodos();
        ObservableList<personaModelo> datos = FXCollections.observableArrayList(listaPersonas);
        tablaBuscarUsuasrios.setItems(datos);
    }


    public void cargarMaestros(){

        idColumnaMaestros.setCellValueFactory(new PropertyValueFactory<>("idUsuarios"));
        columnaNombreMaestros.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));

        List<personaModelo> listaMaestros = personaModelo.buscarMaestros();
        ObservableList<personaModelo> datos = FXCollections.observableArrayList(listaMaestros);
        tablaMaestros.setItems(datos);
    }


    public void crearUsuario(){
        String nombreUsuario = txtNombreCreacion.getText();
        String contrasenia = txtContraseniaCreacion.getText();
        String email = txtEmailCreacion.getText();
        String telefono = txtTelefonoCreacion.getText();
        String tipoUsuario = splitUsuarios.getText();
        LocalDate fecha_creacion = fechaCreacionUsuario.getValue();

        personaModelo.CrearUsuario(nombreUsuario, contrasenia, email, telefono, tipoUsuario, fecha_creacion);

        CargarDatos();
        cargarMaestros();
        limpiarCampos();
    }


    public void EliminarUsuarios(){
        int id_usuarios = Integer.parseInt(txtEliminarUsuarios.getText());
        personaModelo.EliminarUsuario(id_usuarios);
        CargarDatos();
    }


    public void buscarPersona(){

        try {
            int id_usuarios = Integer.parseInt(txtEliminarUsuarios.getText());
            personaModelo persona = personaModelo.buscarPorId(id_usuarios);

            if (persona != null) {
                ObservableList<personaModelo> datos = FXCollections.observableArrayList();
                datos.add(persona);
                tablaBuscarUsuasrios.setItems(datos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el usuario: " + e.getMessage() );
            CargarDatos();
        }
    }

    public void buscarMaestroPorId(){

        try {
            int id_usuarios = Integer.parseInt(txtIdMaestro.getText());
            personaModelo persona = personaModelo.buscarPorIdMaestro(id_usuarios);

            if (persona != null) {
                ObservableList<personaModelo> datos = FXCollections.observableArrayList();
                datos.add(persona);
                tablaMaestros.setItems(datos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el usuario: " + e.getMessage() );
            CargarDatos();
            cargarMaestros();
        }
    }



    public void CrearCurso(){

        try {
            String nombreCurso = txtNombreCurso.getText();
            Integer idMaestro = Integer.parseInt(txtIdMaestro.getText());
            LocalDate fecha_inicio = fechaInicio.getValue();
            LocalDate fecha_final = fechaFinal.getValue();

            cursosModelo.CrearCurso(nombreCurso, idMaestro);
            duracionCursosModelo.DuracionCurso(fecha_inicio, fecha_final);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el curso: " + e.getMessage() );
        }
    }


    public void CargarCursos(){



    }

    @FXML
    public void seteoFechas(){
        LocalDate fechaActual = LocalDate.now();
        fechaInicio.setValue(fechaActual);
        fechaFinal.setValue(fechaActual);
        fechaCreacionUsuario.setValue(fechaActual);
    }

    @FXML
    public void setearTamañoSplit(){
        splitUsuarios.setPrefSize(170, 20);
    }




    private void limpiarCampos(){
        LocalDate fechaActual = LocalDate.now();

        splitUsuarios.setText("usuarios");
        txtNombreCreacion.clear();
        txtContraseniaCreacion.clear();
        txtEmailCreacion.clear();
        txtTelefonoCreacion.clear();
        fechaCreacionUsuario.setValue(fechaActual);
    }
}

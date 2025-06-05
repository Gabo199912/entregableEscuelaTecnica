package org.escuela.escuelacompleto.Modelo;

import org.escuela.escuelacompleto.JDBCUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class cursosModelo {
    private int idDatosCursos;
    private String nombreCurso;
    private int idMaestro;

    public cursosModelo(int idDatosCursos, String nombreCurso, int idMaestro) {
        this.idDatosCursos = idDatosCursos;
        this.nombreCurso = nombreCurso;
        this.idMaestro = idMaestro;
    }

    public cursosModelo(String nombreCurso, int idMaestro) {
        this.nombreCurso = nombreCurso;
        this.idMaestro = idMaestro;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getIdMaestro() {
        return idMaestro;
    }


    public static void CrearCurso(String nombreCurso, int idMaestro){
        String sql = "INSERT INTO CURSOS (nombre_curso, id_maestro) VALUES (?,?)";

        try (Connection con = JDBCUtil.getConeccion();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, nombreCurso);
            ps.setInt(2, idMaestro);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Curso creado con exito");

        }catch (Exception e){
            System.out.println("Error al crear el curso: " + e.getMessage());
        }
    }

    public static List<cursosModelo> ListarCursos(){
        String sql = "SELECT id_datos_cursos, nombre_curso, id_maestro FROM CURSOS";
        List<cursosModelo> listaCursos = new java.util.ArrayList<>();

        try (Connection con = JDBCUtil.getConeccion();
             PreparedStatement ps = con.prepareStatement(sql)){
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 listaCursos.add(new cursosModelo(
                         rs.getInt("id_datos_cursos"),
                         rs.getString("nombre_curso"),
                         rs.getInt("id_maestro")
                 ));
             }
             return listaCursos;

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del curso: " + e.getMessage());
        }
        return listaCursos;
    }
}

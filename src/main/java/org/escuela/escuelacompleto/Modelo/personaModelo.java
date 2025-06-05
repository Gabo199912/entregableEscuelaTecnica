package org.escuela.escuelacompleto.Modelo;

import org.escuela.escuelacompleto.JDBCUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class personaModelo {
    private int idUsuarios;
    private String nombreUsuario;
    private String contrasenia;
    private String tipoUsuario;
    private LocalDate fecha_creacion;
    private LocalDate fecha_nacimiento;
    private String email;
    private String telefono;
    private Boolean activo;



    public personaModelo(int idUsuarios, String nombreUsuario, String tipoUsuario, String email, String telefono) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.telefono = telefono;
    }

    public personaModelo(String nombreUsuario, String contrasenia, String email, String telefono, String tipoUsuario, LocalDate fecha_creacion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.telefono = telefono;
        this.fecha_creacion = fecha_creacion;
    }

    public personaModelo(int idUsuarios, String nombreUsuario){
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Boolean getActivo() {
        return activo;
    }



    public static List<personaModelo> listarTodos(){
        String sql = "SELECT id_usuarios, nombre_usuario, tipo_usuario, email, telefono  FROM PERSONAS";
        List<personaModelo> listaPersonas = new ArrayList<>();

        try (Connection con = JDBCUtil.getConeccion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    listaPersonas.add(new personaModelo(
                            rs.getInt("id_usuarios"),
                            rs.getString("nombre_usuario"),
                            rs.getString("tipo_usuario"),
                            rs.getString("email"),
                            rs.getString("telefono")
                    ));
                }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Error al cargar los datos de la persona: " + e.getMessage() );
        }
        return listaPersonas;
    }

    public static personaModelo buscarPorId(int id_usuarios){
        String sql = "SELECT id_usuarios, nombre_usuario, tipo_usuario, email, telefono  FROM PERSONAS WHERE id_usuarios = ?";

        try (Connection con = JDBCUtil.getConeccion();
         PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id_usuarios);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new personaModelo(
                        rs.getInt("id_usuarios"),
                        rs.getString("nombre_usuario"),
                        rs.getString("tipo_usuario"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
            }

        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Error al cargar los datos de la persona: " + e.getMessage() );
        }
        return null;
    }

    public static personaModelo buscarPorIdMaestro(int id_usuarios){
        String sql = "SELECT id_usuarios, nombre_usuario  FROM PERSONAS WHERE id_usuarios = ?";

        try (Connection con = JDBCUtil.getConeccion();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id_usuarios);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new personaModelo(
                        rs.getInt("id_usuarios"),
                        rs.getString("nombre_usuario")
                );
            }

        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Error al cargar los datos de la persona: " + e.getMessage() );
        }
        return null;
    }

    public static List<personaModelo> buscarMaestros(){
        List<personaModelo> listaPersonas = new ArrayList<>();
        String sql = "SELECT id_usuarios, nombre_usuario  FROM PERSONAS WHERE tipo_usuario = 'maestro'";

        try (Connection con = JDBCUtil.getConeccion();
        PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listaPersonas.add(new personaModelo(
                        rs.getInt("id_usuarios"),
                        rs.getString("nombre_usuario")
                ));

            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Error al cargar los datos de la persona: " + e.getMessage() );
        }

        return listaPersonas;
    }


    public static void CrearUsuario(String nombreUsuario, String contrasenia, String email, String telefono, String tipoUsuario, LocalDate fecha_nacimiento){
        String sql = "INSERT INTO  PERSONAS( nombre_usuario,contrasenia,email,telefono,tipo_usuario,fecha_nacimiento, activo)VALUES (?,?,?,?,?,?,?);";

        try (Connection con = JDBCUtil.getConeccion();
        PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            ps.setString(3, email);
            ps.setString(4, telefono);
            ps.setString(5, tipoUsuario);
            ps.setDate(6, Date.valueOf(fecha_nacimiento));
            ps.setBoolean(7, true);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario creado con exito");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el usuario: " + e.getMessage() );
        }
        }



        public static void EliminarUsuario(int id_usuarios){
            String sql = "DELETE FROM PERSONAS WHERE id_usuarios = ?;";

            try (Connection con = JDBCUtil.getConeccion();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1, id_usuarios);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + e.getMessage() );
            }
        }

}

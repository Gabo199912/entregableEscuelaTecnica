package org.escuela.escuelacompleto.Modelo;

import org.escuela.escuelacompleto.JDBCUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class duracionCursosModelo {
    private int idDuracion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;

    public duracionCursosModelo(LocalDate fecha_inicio, LocalDate fecha_final) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public int getIdDuracion() {
        return idDuracion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }



    public static void DuracionCurso(LocalDate fecha_inicio, LocalDate fecha_final){
        String sql = "INSERT INTO DURACION_CURSOS (fecha_inicio, fecha_final) VALUES (?,?)";

        try (Connection con = JDBCUtil.getConeccion();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(fecha_inicio));
            ps.setDate(2, Date.valueOf(fecha_final));

            ps.executeUpdate();

             } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al crear la duracion del curso: " + e.getMessage());
        }
    }

}

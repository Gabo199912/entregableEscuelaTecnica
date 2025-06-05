package org.escuela.escuelacompleto.Modelo;

import java.util.Date;

public class cursosAlumnosModelo {
    private int idCursosAlumno;
    private int idCursos;
    private Date fechaInscripcion;
    private int idUsuarios;

    public cursosAlumnosModelo(int idCursosAlumno, int idCursos, Date fechaInscripcion, int idUsuarios) {
        this.idCursosAlumno = idCursosAlumno;
        this.idCursos = idCursos;
        this.fechaInscripcion = fechaInscripcion;
        this.idUsuarios = idUsuarios;
    }

    public int getIdCursosAlumno() {
        return idCursosAlumno;
    }

    public void setIdCursosAlumno(int idCursosAlumno) {
        this.idCursosAlumno = idCursosAlumno;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}

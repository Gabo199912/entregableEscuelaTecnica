package org.escuela.escuelacompleto.Modelo;

public class cursosImpartidosModelo {
    private int idCursos;
    private int idDatosCursos;
    private int idDuracion;
    private int notaCurso;
    private Boolean activo;

    public cursosImpartidosModelo(int idCursos, int idDatosCursos, int idDuracion, int notaCurso, Boolean activo) {
        this.idCursos = idCursos;
        this.idDatosCursos = idDatosCursos;
        this.idDuracion = idDuracion;
        this.notaCurso = notaCurso;
        this.activo = activo;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public int getIdDatosCursos() {
        return idDatosCursos;
    }

    public void setIdDatosCursos(int idDatosCursos) {
        this.idDatosCursos = idDatosCursos;
    }

    public int getIdDuracion() {
        return idDuracion;
    }

    public void setIdDuracion(int idDuracion) {
        this.idDuracion = idDuracion;
    }

    public int getNotaCurso() {
        return notaCurso;
    }

    public void setNotaCurso(int notaCurso) {
        this.notaCurso = notaCurso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

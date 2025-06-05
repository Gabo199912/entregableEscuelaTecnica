package org.escuela.escuelacompleto.Modelo;

public class informacionCursos {
    private int idInformacionCursos;
    private int idUsuario;
    private int idDatosCursos;
    private int idDuracion;

    public informacionCursos(int idUsuario, int idDatosCursos, int idDuracion) {
        this.idInformacionCursos = idInformacionCursos;
        this.idUsuario = idUsuario;
        this.idDatosCursos = idDatosCursos;
        this.idDuracion = idDuracion;
    }

    public static void RegistrarCurso(int idUsuario, int idDatosCursos, int idDuracion){


    }
}

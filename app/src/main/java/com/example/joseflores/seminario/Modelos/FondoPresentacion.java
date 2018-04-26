package com.example.joseflores.seminario.Modelos;

/**
 * Created by JoseFlores on 24/04/2018.
 */

public class FondoPresentacion {

    private String idFondo;
    private String nombreFondo;
    private String puntaje;

    public FondoPresentacion(){}

    public FondoPresentacion(String idFondo, String nombreFondo, String puntaje) {
        this.idFondo = idFondo;
        this.nombreFondo = nombreFondo;
        this.puntaje = puntaje;
    }

    public String getIdFondo() {
        return idFondo;
    }

    public void setIdFondo(String idFondo) {
        this.idFondo = idFondo;
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}

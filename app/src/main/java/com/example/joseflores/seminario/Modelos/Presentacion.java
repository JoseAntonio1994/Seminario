package com.example.joseflores.seminario.Modelos;

/**
 * Created by JoseFlores on 24/04/2018.
 */

public class Presentacion {

    private String idFondo;
    private String nombreFondo;
    private int puntaje;

    public Presentacion(){}

    public Presentacion(String idFondo, String nombreFondo, int puntaje) {
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

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

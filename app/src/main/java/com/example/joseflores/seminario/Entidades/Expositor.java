package com.example.joseflores.seminario.Entidades;

import java.io.Serializable;

public class Expositor implements Serializable {

    private Integer idExpositor;
    private String nomExpositor;
    private String nomEvaluador;
    private String nomAsesor;
    private String maestria;
    private String doctorado;
    private String fecha;

    public Expositor() {
    }

    public Expositor(Integer idExpositor, String nomExpositor, String nomEvaluador, String nomAsesor, String maestria, String doctorado, String fecha) {
        this.idExpositor = idExpositor;
        this.nomExpositor = nomExpositor;
        this.nomEvaluador = nomEvaluador;
        this.nomAsesor = nomAsesor;
        this.maestria = maestria;
        this.doctorado = doctorado;
        this.fecha = fecha;
    }

    public Integer getIdExpositor() {
        return idExpositor;
    }

    public void setIdExpositor(Integer idExpositor) {
        this.idExpositor = idExpositor;
    }

    public String getNomExpositor() {
        return nomExpositor;
    }

    public void setNomExpositor(String nomExpositor) {
        this.nomExpositor = nomExpositor;
    }

    public String getNomEvaluador() {
        return nomEvaluador;
    }

    public void setNomEvaluador(String nomEvaluador) {
        this.nomEvaluador = nomEvaluador;
    }

    public String getNomAsesor() {
        return nomAsesor;
    }

    public void setNomAsesor(String nomAsesor) {
        this.nomAsesor = nomAsesor;
    }

    public String getMaestria() {
        return maestria;
    }

    public void setMaestria(String maestria) {
        this.maestria = maestria;
    }

    public String getDoctorado() {
        return doctorado;
    }

    public void setDoctorado(String doctorado) {
        this.doctorado = doctorado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

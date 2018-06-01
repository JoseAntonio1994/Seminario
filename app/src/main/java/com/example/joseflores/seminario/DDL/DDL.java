package com.example.joseflores.seminario.DDL;

public class DDL {

    public static final String TABLA_EXPOSITOR = "expositor";
    public static final String ID_EXPOSITOR = "idExpositor";
    public static final String NOMBRE_EXPOSITOR = "nomExpositor";
    public static final String NOMBRE_EVALUADOR = "nomEvaluador";
    public static final String NOMBRE_ASESOR = "nomAsesor";
    public static final String MAESTRIA = "maestria";
    public static final String DOCTORADO = "doctorado";
    public static final String FECHA = "fecha";

    public static final String CREAR_TABLA_EXPOSITOR = "CREATE TABLE " + TABLA_EXPOSITOR + " ( " + ID_EXPOSITOR + " INTEGER, " + NOMBRE_EXPOSITOR
            + " TEXT, " + NOMBRE_EVALUADOR + " TEXT, " + NOMBRE_ASESOR + " TEXT, " + MAESTRIA + " TEXT, " + DOCTORADO + " TEXT, " + FECHA + " TEXT )";


    public static final String TABLA_PRESENTACION = "presentacion";
    public static final String ID_PRE = "idPresentacion";
    public static final String DESC_PRE = "descPresentacion";
    public static final String PUN_PRE = "punPresentacion";


    public static final String CREAR_TABLA_PRESENTACION = "CREATE TABLE " + TABLA_PRESENTACION + " ( " + ID_PRE + " INTEGER, " + DESC_PRE + " TEXT, "
            + PUN_PRE + " INTEGER )";


    public static final String TABLA_ESTILO = "estilo";
    public static final String ID_ESTILO = "idEstilo";
    public static final String DESC_ESTILO = "descEstilo";
    public static final String PUN_ESTILO = "punEstilo";


    public static final String CREAR_TABLA_ESTILO = "CREATE TABLE " + TABLA_ESTILO + " ( " + ID_ESTILO + " INTEGER, " + DESC_ESTILO + " TEXT, "
            + PUN_ESTILO + " INTEGER )";

    public static final String TABLA_PUNTAJE = "puntaje";
    public static final String TOTAL_PRE = "totalPre";
    public static final String TOTAL_ESTILO = "totalEstilo";
    public static final String TOTAL_PUNTOS = "totalPuntos";

    public static final String CREAR_TABLA_PUNTAJE = "CREATE TABLE " + TABLA_PUNTAJE + " ( " + TOTAL_PRE + " INTEGER, " + TOTAL_ESTILO + " INTEGER, "
            + PUN_ESTILO + " INTEGER )";


}

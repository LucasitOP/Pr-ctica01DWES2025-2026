package main.java.torneo.model;

import main.java.ManoDominante;

import java.util.Date;

public class TenistaAtributos
{
    //id (autonumérico)
    //nombre: nombre del tenista completo
    //pais: nombre del país
    //altura: altura del tenista en cm
    //peso: peso del tenista en kg
    //puntos: puntos totales del tenista
    //mano: mano del tenista, DIESTRO o ZURDO
    //fecha_nacimiento: fecha de nacimiento del tenista, en formato AAAA-MM-DD (ISO 8601)

    private int id;
    private String nombre;
    private int altura;
    private int peso;
    private int puntosTotales;
    private ManoDominante mano;
    private Date fec_nac;



}

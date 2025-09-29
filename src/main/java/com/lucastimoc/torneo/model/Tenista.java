package com.lucastimoc.torneo.model;

public class Tenista {
    public String nombre;
    public String pais;
    public int altura;
    public int peso;
    public int puntos;
    public String mano;
    public String fechaNacimiento;
    public String createdAt;
    public String updatedAt;

    public Tenista(String nombre, String pais, int altura, int peso, int puntos, String mano, String fechaNacimiento, String createdAt, String updatedAt) {
        this.nombre = nombre;
        this.pais = pais;
        this.altura = altura;
        this.peso = peso;
        this.puntos = puntos;
        this.mano = mano;
        this.fechaNacimiento = fechaNacimiento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
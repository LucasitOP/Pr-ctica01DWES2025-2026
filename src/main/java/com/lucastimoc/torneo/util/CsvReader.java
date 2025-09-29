package com.lucastimoc.torneo.util;

import com.lucastimoc.torneo.model.Tenista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Tenista> leerTenistas(String path) {
        List<Tenista> tenistas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 9) continue; // Validación básica

                Tenista t = new Tenista(
                        partes[0], // nombre
                        partes[1], // pais
                        Integer.parseInt(partes[2]), // altura
                        Integer.parseInt(partes[3]), // peso
                        Integer.parseInt(partes[4]), // puntos
                        partes[5], // mano
                        partes[6], // fechaNacimiento
                        partes[7], // createdAt
                        partes[8]  // updatedAt
                );
                tenistas.add(t);
            }
        } catch (Exception e) {
            System.err.println("❌ Error al leer el CSV: " + e.getMessage());
        }
        return tenistas;
    }
}
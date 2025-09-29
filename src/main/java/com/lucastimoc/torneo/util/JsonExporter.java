package com.lucastimoc.torneo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucastimoc.torneo.model.Tenista;

import java.io.File;
import java.util.List;

public class JsonExporter {
    public static void exportar(List<Tenista> tenistas, String pathSalida) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(pathSalida), tenistas);
            System.out.println("📁 Archivo JSON generado en: " + pathSalida);
        } catch (Exception e) {
            System.err.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }
}
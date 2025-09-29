package com.lucastimoc.torneo;

import com.lucastimoc.torneo.model.Tenista;
import com.lucastimoc.torneo.repository.DataBaseManager;
import com.lucastimoc.torneo.util.CsvReader;
import com.lucastimoc.torneo.util.TenistaValidator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseManager.initializeDatabase();

        if (args.length < 1) {
            System.out.println("❗ Debes indicar el archivo CSV de entrada.");
            return;
        }

        String pathEntrada = args[0];
        List<Tenista> tenistas = CsvReader.leerTenistas(pathEntrada);
        int insertados = 0;
        int rechazados = 0;

        for (Tenista t : tenistas) {
            if (TenistaValidator.esValido(t)) {
                DataBaseManager.insertarTenista(t);
                insertados++;
            } else {
                System.out.println("⚠️ Tenista inválido: " + t.nombre);
                rechazados++;
            }
        }

        System.out.println("✅ Tenistas insertados: " + insertados);
        System.out.println("❌ Tenistas rechazados: " + rechazados);
    }
}
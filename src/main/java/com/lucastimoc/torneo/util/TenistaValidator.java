package com.lucastimoc.torneo.util;

import com.lucastimoc.torneo.model.Tenista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TenistaValidator {

    public static boolean esValido(Tenista t) {
        if (t.nombre == null || t.nombre.isBlank()) return false;
        if (t.pais == null || t.pais.isBlank()) return false;
        if (t.altura < 100 || t.altura > 250) return false; // altura en cm
        if (t.peso < 40 || t.peso > 200) return false; // peso en kg
        if (t.puntos < 0) return false;
        if (!t.mano.equalsIgnoreCase("DIESTRO") && !t.mano.equalsIgnoreCase("ZURDO")) return false;

        try {
            LocalDate.parse(t.fechaNacimiento); // formato AAAA-MM-DD
            LocalDate.parse(t.createdAt.substring(0, 10)); // solo fecha
            LocalDate.parse(t.updatedAt.substring(0, 10));
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }
}
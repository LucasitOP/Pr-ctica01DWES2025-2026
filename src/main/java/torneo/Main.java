package main.java.torneo;


import main.java.torneo.util.DatabaseUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try (Connection conn =
                     DatabaseUtils.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM tenistas");
            System.out.println("\u001B[33mBase de datos limpiada correctamente\u001B[0m");
        } catch (SQLException e) {
            System.err.println("\u001B[31mError al limpiar la base de datos: " + e.getMessage() + "\u001B[0m");
        }


    }
}
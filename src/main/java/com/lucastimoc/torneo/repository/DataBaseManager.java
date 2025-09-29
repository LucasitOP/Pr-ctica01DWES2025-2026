package com.lucastimoc.torneo.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.lucastimoc.torneo.model.Tenista;

public class DataBaseManager {
    private static final String DB_URL = "jdbc:sqlite:torneo_tenis.db";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = """
                DROP TABLE IF EXISTS tenistas;
                CREATE TABLE tenistas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    pais TEXT NOT NULL,
                    altura INTEGER NOT NULL,
                    peso INTEGER NOT NULL,
                    puntos INTEGER NOT NULL,
                    mano TEXT CHECK(mano IN ('DIESTRO','ZURDO')) NOT NULL,
                    fecha_nacimiento TEXT NOT NULL,
                    created_at TEXT NOT NULL,
                    updated_at TEXT NOT NULL
                );
            """;
            stmt.executeUpdate(sql);
            System.out.println("✅ Base de datos inicializada correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al inicializar la base de datos: " + e.getMessage());
        }
    }
    public static void insertarTenista(Tenista t) {
        String sql = "INSERT INTO tenistas (nombre, pais, altura, peso, puntos, mano, fecha_nacimiento, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, t.nombre);
            pstmt.setString(2, t.pais);
            pstmt.setInt(3, t.altura);
            pstmt.setInt(4, t.peso);
            pstmt.setInt(5, t.puntos);
            pstmt.setString(6, t.mano);
            pstmt.setString(7, t.fechaNacimiento);
            pstmt.setString(8, t.createdAt);
            pstmt.setString(9, t.updatedAt);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("❌ Error al insertar tenista: " + e.getMessage());
        }
    }
}
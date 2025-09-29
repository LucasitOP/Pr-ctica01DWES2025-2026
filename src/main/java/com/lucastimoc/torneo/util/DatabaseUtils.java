package main.java.torneo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:sqlite:torneo_tenis.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}

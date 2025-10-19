package com.colegio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String HOST = EnvLoader.get("DB_HOST");
    private static final String PORT = EnvLoader.get("DB_PORT");
    private static final String NAME = EnvLoader.get("DB_NAME");
    private static final String USER = EnvLoader.get("DB_USER");
    private static final String PASSWORD = EnvLoader.get("DB_PASSWORD");

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + NAME +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver MySQL cargado.");
            System.out.println("🔗 URL de conexión: " + URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ No se pudo cargar el driver de MySQL");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

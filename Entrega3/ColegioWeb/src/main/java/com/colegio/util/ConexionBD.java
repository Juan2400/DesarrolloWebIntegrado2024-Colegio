package com.colegio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // 🔐 Variables cargadas desde el archivo .env
    private static final String HOST = EnvLoader.get("GA_DB_HOST");
    private static final String PORT = EnvLoader.get("GA_DB_PORT");
    private static final String NAME = EnvLoader.get("GA_DB_NAME");
    private static final String USER = EnvLoader.get("GA_DB_USER");
    private static final String PASSWORD = EnvLoader.get("GA_DB_PASSWORD");

    // 📦 Construcción de la URL de conexión
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + NAME +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver MySQL cargado correctamente.");
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

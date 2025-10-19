package com.colegio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String HOST = EnvLoader.get("DB_HOST");
    private static final String PORT = EnvLoader.get("DB_PORT");
    private static final String NAME = EnvLoader.get("DB_NAME");
    private static final String USER = EnvLoader.get("DB_USER");
    private static final String PASSWORD = EnvLoader.get("DB_PASSWORD");

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + NAME + "?useSSL=false&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver no encontrado.", e);
        }
    }
}

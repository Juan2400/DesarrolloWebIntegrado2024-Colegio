package com.colegio.util;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection con = DatabaseConnection.getConnection()) {
            if (con != null) {
                System.out.println("✅ Conexión exitosa a la base de datos.");
            } else {
                System.out.println("❌ No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

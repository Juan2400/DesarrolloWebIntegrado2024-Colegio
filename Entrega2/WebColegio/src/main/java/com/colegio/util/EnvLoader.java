package com.colegio.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {

    private static final Map<String, String> env = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(EnvLoader.class.getClassLoader().getResourceAsStream(".env")))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        env.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }
            System.out.println("✅ Archivo .env cargado desde resources correctamente.");
        } catch (Exception e) {
            System.err.println("⚠️ No se pudo cargar el archivo .env desde resources: " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = env.get(key);
        if (value == null || value.isEmpty()) {
            System.err.println("⚠️ La variable de entorno '" + key + "' no está definida o está vacía.");
        }
        return value;
    }
}

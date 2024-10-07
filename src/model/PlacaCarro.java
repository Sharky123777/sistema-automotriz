package model;

import java.util.HashSet;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlacaCarro {
    private static HashSet<String> placasExistentes = new HashSet<>(); // Aquí guardamos las placas ya existentes

    public static String generarPlacaUnica() {
        String nuevaPlaca;
        do {
            nuevaPlaca = generarPlacaAleatoria();
        } while (placasExistentes.contains(nuevaPlaca)); // Verifica si la placa ya existe

        placasExistentes.add(nuevaPlaca); // Agregar la nueva placa a las existentes
        return nuevaPlaca;
    }

    private static String generarPlacaAleatoria() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        StringBuilder placa = new StringBuilder();
        placa.append(letras.charAt(random.nextInt(letras.length()))); // Letra aleatoria
        placa.append(letras.charAt(random.nextInt(letras.length()))); // Letra aleatoria
        placa.append(letras.charAt(random.nextInt(letras.length()))); // Letra aleatoria
        placa.append("-"); // Separador
        placa.append(numeros.charAt(random.nextInt(numeros.length()))); // Número aleatorio
        placa.append(numeros.charAt(random.nextInt(numeros.length()))); // Número aleatorio
        placa.append(numeros.charAt(random.nextInt(numeros.length()))); // Número aleatorio

        return placa.toString();
    }

    // Método para cargar placas existentes desde la base de datos
    public static void cargarPlacasExistentes() {
        String url = "jdbc:mysql://localhost:3306/inventario_autos"; // URL de tu base de datos
        String usuario = "tu_usuario"; // Cambia esto por tu usuario
        String contraseña = "tu_contraseña"; // Cambia esto por tu contraseña

        String sql = "SELECT placa FROM autos"; // Consulta para obtener las placas

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            // Limpiar el conjunto antes de cargar los nuevos datos
            placasExistentes.clear();

            // Cargar las placas existentes en el HashSet
            while (rs.next()) {
                placasExistentes.add(rs.getString("placa"));
            }

            System.out.println("Placas existentes cargadas: " + placasExistentes);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    // Método para obtener el conjunto de placas existentes
    public static HashSet<String> getPlacasExistentes() {
        return placasExistentes;
    }
}

package model;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class carroDao {

     public List<car> obtenerCarros() {
        List<car> cars = new ArrayList<>();
        String sql = "SELECT marca, modelo, año, precio, color, tipo_motor, fecha_ingreso, kilometraje, placa, cantidad FROM autos";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

           while (rs.next()) {
            // Obtener los valores de la base de datos
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String año = rs.getString("año");
            Double precio = rs.getDouble("precio");
            String color = rs.getString("color");
            String tipoMotor = rs.getString("tipo_motor");
            String fechaIngresoo = rs.getString("fecha_ingreso");
            String kilometraje = rs.getString("kilometraje");
            String placa = rs.getString("placa");
            int cantidad = rs.getInt("cantidad");

            car carr = new car(marca, modelo, año, precio, color, tipoMotor, fechaIngresoo, kilometraje, placa, cantidad);
            
            cars.add(carr);
        }

    } catch (SQLException e) {
        System.err.println("Error al obtener autos: " + e.getMessage());
    }

    return cars;
    }
    
    public void contratarProfesor(String nombre, String apellidos, String correo, String telefono, LocalDate fechaContratacion, String materia) {
    String codigo = generarCodigoProfesor();

    String sql = "INSERT INTO profesores (codigo_profesor, nombre, apellido, correo_electronico, telefono, fecha_contratacion, materia) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setString(1, codigo);
        pstmt.setString(2, nombre);
        pstmt.setString(3, apellidos);
        pstmt.setString(4, correo);
        pstmt.setString(5, telefono);
        pstmt.setDate(6, java.sql.Date.valueOf(fechaContratacion));
        pstmt.setString(7, materia);

        pstmt.executeUpdate();
        System.out.println("Profesor insertado con exito.");
        
    } catch (SQLException e) {
        System.err.println("Error al insertar el profesor: " + e.getMessage());
    }
}


    private String generarCodigoProfesor() {
        String codigo = "PROF001"; 
        String sql = "SELECT codigo_profesor FROM profesores ORDER BY codigo_profesor DESC LIMIT 1";  

        try (Connection con = ConexionBD.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                String ultimoCodigo = rs.getString("codigo_profesor");
                int numero = Integer.parseInt(ultimoCodigo.substring(4));  
                numero++;
                codigo = String.format("PROF%03d", numero);
            }
        } catch (SQLException e) {
            System.err.println("Error al generar el codigo de profesor: " + e.getMessage());
        }
       

        return codigo;
    }
}
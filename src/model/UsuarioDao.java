package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class UsuarioDao {
    
    private Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/inventario_autos";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
        return conn;
    }

    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";  
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
            return false;
        }
    }
}
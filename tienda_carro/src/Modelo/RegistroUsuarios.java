
package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class RegistroUsuarios {

    public static ArrayList<String[]> listaUsuarios = new ArrayList<>();

    // Método para agregar un usuario tanto en memoria como en la base de datos
    public static void agregarUsuario(String nombre, String correo, String contrasena) {
        // Guardar en memoria
        listaUsuarios.add(new String[] { nombre, correo, contrasena });

        // Guardar en la base de datos
        try {
            Connection conn = ConexionBD.getConexion();
            String sql = "INSERT INTO usuarios (nombre, correo, contrasena) VALUES (?, ?, ?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener los usuarios desde la base de datos
    public static ArrayList<String[]> obtenerUsuarios() {
        ArrayList<String[]> usuarios = new ArrayList<>();

        try {
            // Conectar a la base de datos
            Connection conn = ConexionBD.getConexion();
            String sql = "SELECT nombre, correo, contrasena FROM usuarios";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Recorrer los resultados de la consulta
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contrasena");
                usuarios.add(new String[]{nombre, correo, contrasena});
            }

            // Cerrar recursos
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}

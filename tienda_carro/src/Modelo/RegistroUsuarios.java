
package Modelo;

import java.util.ArrayList;

public class RegistroUsuarios {
    public static ArrayList<String[]> listaUsuarios = new ArrayList<>();

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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Franco
 */
public class DBConnection {

    private static final String url = "jdbc:postgresql://localhost/develop_guayana";
    private static final String user = "postgres";
    private static final String password = "1234";

    public static Connection conn;

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static ResultSet login(String user, String password)
            throws SQLException {

        Statement stmt = null;
        String query = "SELECT id_trabajador, nombre_completo, cedula, cargo, usuario, clave FROM public.trabajador WHERE usuario = '" + user + "' AND clave = '" + password + "';";
        try {
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }/* finally {
            if (stmt != null) {
                stmt.close();
            }
        }*/

        return null;
    }
    
     public static ResultSet getTrabajadores()
            throws SQLException {

        Statement stmt = null;
        String query = "SELECT id_trabajador, nombre_completo, cedula, cargo, usuario, clave FROM public.trabajador ORDER BY nombre_completo;";
        try {
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }/* finally {
            if (stmt != null) {
                stmt.close();
            }
        }*/

        return null;
    }
     
     public static ResultSet getClientes()
            throws SQLException {

        Statement stmt = null;
        String query = "SELECT id_cliente, nombre, direccion, telefono, correo, tipo, rif FROM public.cliente ORDER BY nombre;";
        try {
            stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }/* finally {
            if (stmt != null) {
                stmt.close();
            }
        }*/

        return null;
    }

    public static int executeQuery(String sql) throws SQLException {
        System.out.println("SQL : " + sql);
        Statement stmt = connect().createStatement();
        return stmt.executeUpdate(sql);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.connect();
    }
}

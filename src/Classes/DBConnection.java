/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private static final String password = "admin";
//https://github.com/JValderramaN/DevelopGuayana.git
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

    public static ResultSet getRecursos(Integer idTarea)
            throws SQLException {
        Statement stmt = null;
        String query;
        if (idTarea == null) {
            query = "SELECT id_recurso, id_trabajador, nombre, disponibilidad FROM public.recurso ORDER BY nombre;";
        } else {
            query = "SELECT re.id_recurso, re.nombre, tr.cantidad_uso FROM public.recurso re INNER JOIN "
                    + "public.tarea_recurso tr ON (re.id_recurso = tr.id_recurso) INNER JOIN public.tarea t ON "
                    + "(tr.id_tarea = t.id_tarea) WHERE t.id_tarea = " + idTarea + " ORDER BY re.nombre;";
        }

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

    public static ResultSet getProyectos(Integer idCliente, Integer idTrabajador)
            throws SQLException {
        Statement stmt = null;
        String query = "";

        if (idCliente != null) {
            if (idTrabajador != null) {
                 query = " SELECT p.id_proyecto, p.estado, p.cliente_asociado, p.lider_proyecto, p.duracion, p.nombre pn, "
                         + "t.nombre_completo,c.nombre cn "
                         + "FROM public.proyecto p INNER JOIN public.trabajador t ON (p.lider_proyecto = t.id_trabajador) INNER JOIN "
                         + "public.cliente c ON (p.cliente_asociado = c.id_cliente) INNER JOIN public.tarea ta ON (p.id_proyecto = "
                         + "ta.id_proyecto) "
                         + "INNER JOIN public.tarea_recurso tr ON (tr.id_tarea = ta.id_tarea) INNER JOIN public.recurso r ON "
                         + "(r.id_recurso = tr.id_recurso) WHERE r.id_trabajador = " +idTrabajador+ " AND p.cliente_asociado = " +idCliente+"";
            }else{
                query = "SELECT p.id_proyecto, p.estado, p.cliente_asociado, p.lider_proyecto, p.duracion, p.nombre pn, t.nombre_completo,c.nombre cn "
                + "FROM public.proyecto p INNER JOIN public.trabajador t ON (p.lider_proyecto = t.id_trabajador) INNER JOIN "
                + "public.cliente c ON (p.cliente_asociado = c.id_cliente) WHERE p.cliente_asociado = " + idCliente;
            }

        }else{
            if (idTrabajador != null) {
                query = " SELECT p.id_proyecto, p.estado, p.cliente_asociado, p.lider_proyecto, p.duracion, p.nombre pn, "
                         + "t.nombre_completo,c.nombre cn "
                         + "FROM public.proyecto p INNER JOIN public.trabajador t ON (p.lider_proyecto = t.id_trabajador) INNER JOIN "
                         + "public.cliente c ON (p.cliente_asociado = c.id_cliente) INNER JOIN public.tarea ta ON (p.id_proyecto = "
                         + "ta.id_proyecto) "
                         + "INNER JOIN public.tarea_recurso tr ON (tr.id_tarea = ta.id_tarea) INNER JOIN public.recurso r ON "
                         + "(r.id_recurso = tr.id_recurso) WHERE r.id_trabajador = " +idTrabajador+ "";
            }else{
                query = "SELECT p.id_proyecto, p.estado, p.cliente_asociado, p.lider_proyecto, p.duracion, p.nombre pn, t.nombre_completo,c.nombre cn "
                + "FROM public.proyecto p INNER JOIN public.trabajador t ON (p.lider_proyecto = t.id_trabajador) INNER JOIN "
                + "public.cliente c ON (p.cliente_asociado = c.id_cliente)";
            }
        }

        query += " ORDER BY p.nombre;";
        System.out.println("query " +query);
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

    //idTarea para no incluirla
    public static ResultSet getTareas(Integer idProyecto, Integer idTarea)
            throws SQLException {
        Statement stmt = null;
        String query = "SELECT t.id_tarea, t.nombre, t.duracion_estimada, to_char(t.fecha_inicio_prevista, 'DD/MM/YYYY') fecha_inicio_prevista, "
                + "t.id_proyecto, t.id_trabajador,t.estado, t.porcentaje_avance,tra.nombre_completo  FROM public.tarea t INNER JOIN "
                + "public.trabajador tra ON (t.id_trabajador = tra.id_trabajador) ";

        //tiene tarea
        if (idTarea != null) {
            //tiene tarea y proyecto
            if (idProyecto != null) {
                query += "WHERE t.id_proyecto = " + idProyecto + " AND t.id_tarea !=" + idTarea;
            } else {//tiene tarea y no proyecto
                query += "WHERE  t.id_tarea !=" + idTarea;
            }
        } else {//no tiene tarea
            //no tiene tarea, tiene proyecto
            if (idProyecto != null) {
                query += "WHERE t.id_proyecto = " + idProyecto;
            }
        }

        query += " ORDER BY t.nombre;";
        try {
            System.out.println(query);
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

    public static ResultSet getTareaDependencias(int idTarea)
            throws SQLException {
        Statement stmt = null;
        String query = "SELECT t.id_tarea, t.nombre  FROM public.tarea t INNER JOIN public.tarea_dependencia "
                + "td ON (t.id_tarea =  td.id_tarea_requerida) WHERE td.id_tarea = " + idTarea + " ORDER BY t.nombre;";
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

    public static Integer executeQueryReturnID(String sql) throws SQLException {
        System.out.println("SQL : " + sql);

        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.execute();
        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.connect();
    }
}

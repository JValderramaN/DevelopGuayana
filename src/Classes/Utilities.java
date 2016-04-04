/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franco
 */
public class Utilities {

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Ha sucedido un error", 0);
    }

    public static void setDataIntoComboBox(JComboBox<String> comboBox, Vector ids, ResultSet rs, String fieldToShow, String fieldToStore) {
        try {
            ids.removeAllElements();
            comboBox.removeAllItems();
            while (rs.next()) {
                comboBox.addItem(rs.getString(fieldToShow));
                ids.add(rs.getInt(fieldToStore));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDataIntoTable(JTable tabla, ResultSet rs, String[] campos,String[] columnas) {
        try {
            DefaultTableModel model = new DefaultTableModel(columnas, 0);
            while (rs.next()) {
                Vector rowData = new Vector();
                for (int i = 0; i < campos.length; i++) {
                    rowData.add(rs.getObject(campos[i]));
                }
                model.addRow(rowData);
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setDataIntoList(JList lista,Vector ids, ResultSet rs, String fieldToShow, String fieldToStore) {
        try {
            ids.removeAllElements();   
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getString(fieldToShow));
                ids.add(rs.getInt(fieldToStore));
            }
            lista.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getTrabajadoresWithComboBox(JComboBox<String> comboBox, Vector ids) {
        try {
            Utilities.setDataIntoComboBox(comboBox, ids, DBConnection.getTrabajadores(), "nombre_completo", "id_trabajador");
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getTrabajadoresWithTable(JTable tabla) {
        if (tabla == null) {
            return;
        }

        try {
            String[] columnas = new String[]{"ID", "Nombre", "Cédula", "Cargo", "Usuario", "Clave"};
            String[] campos = new String[]{"id_trabajador", "nombre_completo", "cedula", "cargo", "usuario", "clave"};
            
            Utilities.setDataIntoTable(tabla, DBConnection.getTrabajadores(),campos, columnas);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getClientesWithComboBox(JComboBox<String> comboBox, Vector ids) {
        try {
            Utilities.setDataIntoComboBox(comboBox, ids, DBConnection.getClientes(), "nombre", "id_cliente");
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getClientesWithTable(JTable tabla) {
        if (tabla == null) {
            return;
        }

        try {
            String[] columnas = new String[]{"ID", "Nombre", "Dirección", "Teléfono", "Correo", "Tipo","Rif"};
            String[] campos = new String[]{"id_cliente", "nombre", "direccion", "telefono", "correo", "tipo", "rif"};
            
            Utilities.setDataIntoTable(tabla, DBConnection.getClientes(),campos, columnas);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getRecursosWithTable(JTable tabla) {
        if (tabla == null) {
            return;
        }

        try {
            String[] columnas = new String[]{"ID", "ID Trabajador", "Nombre", "Disponibilidad"};
            String[] campos = new String[]{"id_recurso","id_trabajador", "nombre", "disponibilidad"};
            
            Utilities.setDataIntoTable(tabla, DBConnection.getRecursos(),campos, columnas);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getProyectosWithTable(JTable tabla) {
        if (tabla == null) {
            return;
        }

        try {
            String[] columnas = new String[]{"ID", "Nombre", "Cliente Asociado", "Lider de Proyecto", "Estado", "Duración (Días)"};
            String[] campos = new String[]{"id_proyecto", "pn", "cn", "nombre_completo", "estado", "duracion"};
            
            Utilities.setDataIntoTable(tabla, DBConnection.getProyectos(),campos, columnas);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getTareasWithComboBox(JComboBox<String> comboBox, Vector ids, Integer idProyecto,Integer idTarea) {
        try {
            Utilities.setDataIntoComboBox(comboBox, ids, DBConnection.getTareas(idProyecto, idTarea), "nombre", "id_tarea");
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getTareasWithTable(JTable tabla, int idProyecto, ResultSet data) {
        if (tabla == null) {
            return;
        }

        try {
            String[] columnas = new String[]{"ID", "Nombre", "Tarea Asociada", "Responsable", "Duración (Días)", "Fecha de inicio", "% Avance"};
            String[] campos = new String[]{"id_tarea", "nombre", "id_tarea_asociada", "id_trabajador", 
                "duracion_estimada", "fecha_inicio_prevista","porcentaje_avance"};
            
            Utilities.setDataIntoTable(tabla,data != null ? data : DBConnection.getTareas(idProyecto, null),campos, columnas);
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getTareasWithList(JList lista, Vector ids, Integer idProyecto,Integer idTarea) {
        if (lista == null) {
            return;
        }

        try {
            Utilities.setDataIntoList(lista, ids, DBConnection.getTareas(idProyecto,idTarea), "nombre", "id_tarea");
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteRowTable(JTable tabla) {
        if (tabla.getSelectedRow() == -1) {
            return;
        }

        ((DefaultTableModel) tabla.getModel()).removeRow(tabla.getSelectedRow());
    }

}

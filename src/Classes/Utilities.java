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
import javax.swing.JComboBox;
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
            ids = new Vector();
            comboBox.removeAllItems();
            while (rs.next()) {
                comboBox.addItem(rs.getString(fieldToShow));
                ids.add(rs.getInt(fieldToStore));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDataIntoTable(JTable tabla, ResultSet rs, String[] columnas) {
        try {
            DefaultTableModel model = new DefaultTableModel(columnas, 0);
            while (rs.next()) {
                Vector rowData = new Vector();
                for (int i = 0; i < columnas.length; i++) {
                    rowData.add(rs.getObject(i + 1));
                }
                model.addRow(rowData);
            }
            tabla.setModel(model);
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
            Utilities.setDataIntoTable(tabla, DBConnection.getTrabajadores(), columnas);
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
    
    public static void deleteRowTable(JTable tabla){
        if(tabla.getSelectedRow() == -1){
            return;
        }
        
        ((DefaultTableModel)tabla.getModel()).removeRow(tabla.getSelectedRow());
    }

}

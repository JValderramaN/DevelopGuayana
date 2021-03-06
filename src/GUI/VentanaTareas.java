/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.DBConnection;
import Classes.Utilities;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franco
 */
public class VentanaTareas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaUsuarios
     */
    private int idProyecto;

    private Vector<Integer> idsTareas = new Vector<>();

    public VentanaTareas(Integer idProyecto, String nombreProyecto) {
        initComponents();
        setLocationRelativeTo(null);
        this.idProyecto = idProyecto;
        textfieldNombreProyecto.setText(nombreProyecto);
        updateData();
    }

    public void updateData() {
        Utilities.getTareasWithTable(tablaTareas, idProyecto, null);

        if (tablaTareas.getRowCount() > 0) {
            tablaTareas.setRowSelectionInterval(0, 0);
            tablaTareasMouseClicked(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonCrear = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        textfieldNombreProyecto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTareasRequeridas = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        buttonEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proyectos");

        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaTareas.getTableHeader().setReorderingAllowed(false);
        tablaTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTareasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTareas);

        jLabel1.setText("Tareas por proyecto");

        jLabel2.setText("Tareas Registradas para el proyecto:");

        buttonCrear.setText("Crear");
        buttonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearActionPerformed(evt);
            }
        });

        buttonModificar.setText("Modificar");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        textfieldNombreProyecto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setText("Tareas requeridas:");

        listTareasRequeridas.setEnabled(false);
        jScrollPane2.setViewportView(listTareasRequeridas);

        tablaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaRecursos.setEnabled(false);
        tablaRecursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaRecursos);

        jLabel4.setText("Recursos requeridos:");

        buttonEstado.setText("Iniciar Tarea");
        buttonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 217, Short.MAX_VALUE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonCrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textfieldNombreProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(textfieldNombreProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonModificar)
                            .addComponent(buttonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEliminar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearActionPerformed

        new CrearTarea(this, idProyecto, null, null).setVisible(true);

    }//GEN-LAST:event_buttonCrearActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        if (tablaTareas.getSelectedRow() == -1) {
            return;
        }

        String sql = "DELETE FROM public.tarea WHERE id_tarea = " + tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 0) + ";";
        try {
            int result = DBConnection.executeQuery(sql);
            if (result == 1) {
                Utilities.deleteRowTable(tablaTareas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            Utilities.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        if (tablaTareas.getSelectedRow() == -1) {
            return;
        }
        
        if(((String) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 5)).equals("Terminada")){
            return;
        }

        new CrearTarea(this,
                idProyecto,
                (int) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 0),
                (String) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 1),
                (String) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 2),
                (int) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 3),
                (String) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 4),
                ((DefaultListModel) listTareasRequeridas.getModel()).toArray(),
                tablaRecursos
        ).setVisible(true);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void tablaTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTareasMouseClicked

        if (tablaTareas.getSelectedRow() == -1) {
            buttonEstado.setText("No iniciada");
            buttonEstado.setVisible(false);
            return;
        }

        try {

            String estado = (String) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 5);
            if (estado.equals("No iniciada")) {
                buttonEstado.setText("Iniciar Tarea");
                buttonEstado.setVisible(true);
            } else if (estado.equals("En proceso")) {
                buttonEstado.setText("Terminar Tarea");
                buttonEstado.setVisible(true);
            }else if (estado.equals("Terminada")) {
                buttonEstado.setVisible(false);
            }

            int id = (int) tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 0);

            Utilities.getTareasWithList(listTareasRequeridas, idsTareas, idProyecto, id, DBConnection.getTareaDependencias(id));
            Utilities.getRecursosWithTable(tablaRecursos, id);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tablaTareasMouseClicked

    private void buttonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstadoActionPerformed
        if (tablaTareas.getSelectedRow() == -1) {
            return;
        }
        
        String sql = "";
        if (buttonEstado.getText().equals("Iniciar Tarea")) {
            sql = "UPDATE tarea SET  estado = 'En proceso' WHERE id_tarea = " + tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 0) + ";";
            tablaTareas.setValueAt("En proceso", tablaTareas.getSelectedRow(), 5);
            buttonEstado.setText("Terminar Tarea");
        } else if (buttonEstado.getText().equals("Terminar Tarea")) {
            sql = "UPDATE tarea SET  estado = 'Terminada' WHERE id_tarea = " + tablaTareas.getValueAt(tablaTareas.getSelectedRow(), 0) + ";";
            tablaTareas.setValueAt("Terminada", tablaTareas.getSelectedRow(), 5);
            buttonEstado.setVisible(false);
        }

        try {
            DBConnection.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTareas(0, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCrear;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonEstado;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listTareasRequeridas;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JLabel textfieldNombreProyecto;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.DBConnection;
import Classes.Utilities;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Franco
 */
public class CrearCliente extends javax.swing.JFrame {

    /**
     * Creates new form CrearUsuario
     */
    private JTable tabla;
    private int id = -1;

    public CrearCliente() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public CrearCliente(JTable tabla) {
        this();
        this.tabla = tabla;
    }

    public CrearCliente(JTable tabla, int id, String nombre, String direccion, String telefono, String email, String tipo,  String rif) {
        this(tabla);
        this.setTitle("Modificar Cliente");
        titulo.setText("Modificar Cliente");
        this.id = id;
        buttonCrearCliente.setText("Modificar Cliente");
        textfieldNombre.setText(nombre);
        textfieldDireccion.setText(direccion);
        textfieldTelefono.setText(telefono);
        textfieldRif.setText(rif);
        textfieldEmail.setText(email);
        comboboxTipo.setSelectedItem(tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textfieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textfieldDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textfieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textfieldRif = new javax.swing.JTextField();
        comboboxTipo = new javax.swing.JComboBox<>();
        buttonCrearCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textfieldTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Cliente");

        titulo.setText("Crear Cliente");

        jLabel2.setText("Nombre");

        jLabel3.setText("Datos del Cliente");

        jLabel4.setText("Dirección");

        jLabel5.setText("Teléfono");

        jLabel6.setText("Email");

        jLabel7.setText("Tipo");

        comboboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));

        buttonCrearCliente.setText("Crear Cliente");
        buttonCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearClienteActionPerformed(evt);
            }
        });

        jLabel8.setText("Rif");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(titulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(buttonCrearCliente)))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldDireccion)
                                    .addComponent(textfieldNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textfieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldRif, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldTelefono)
                                    .addComponent(comboboxTipo, 0, 183, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textfieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textfieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textfieldRif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textfieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonCrearCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearClienteActionPerformed
        String sql, mensaje;

        if (id == -1) {
            sql = "INSERT INTO public.cliente(nombre, direccion, telefono, correo, tipo, rif) VALUES ( '"
                    + textfieldNombre.getText() + "', '"
                    + textfieldDireccion.getText() + "', '"
                    + textfieldTelefono.getText() + "', '"
                    + textfieldEmail.getText() + "', '"
                    + (String) comboboxTipo.getSelectedItem() + "', '"
                    + textfieldRif.getText() + "');";
            mensaje = "Cliente creado satisfactoriamente";
        } else {
            sql = "UPDATE public.cliente SET nombre = '"
                    + textfieldNombre.getText() + "',direccion = '"
                    + textfieldDireccion.getText() + "',telefono = '"
                    + textfieldTelefono.getText() + "',correo = '"
                    + textfieldEmail.getText() + "',tipo = '"
                    + (String) comboboxTipo.getSelectedItem() + "',rif = '"
                    + textfieldRif.getText()  + "' WHERE id_cliente = "+id+";";
            mensaje = "Cliente modificado satisfactoriamente";
        }

        try {
            int result = DBConnection.executeQuery(sql);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, mensaje);

                Utilities.getClientesWithTable(tabla);

                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utilities.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_buttonCrearClienteActionPerformed

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
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCrearCliente;
    private javax.swing.JComboBox<String> comboboxTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField textfieldDireccion;
    private javax.swing.JTextField textfieldEmail;
    private javax.swing.JTextField textfieldNombre;
    private javax.swing.JTextField textfieldRif;
    private javax.swing.JTextField textfieldTelefono;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

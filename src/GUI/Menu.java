package GUI;

 import java.sql.*;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLExeption;
 import java.sql.Statement;
 import java.util.*;
 import javax.swing.JOptionPane;
 
public class Menu extends javax.swing.JFrame {

    
    private Connection connection = null;
    private ResultSet ra = null;
    private Statement s = null;
    
    
    
    
    public Menu() {
        initComponents();
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonProyectos = new javax.swing.JButton();
        buttonRecursos = new javax.swing.JButton();
        buttonClientes = new javax.swing.JButton();
        buttonUsuarios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonProyectos.setText("Proyectos");
        buttonProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProyectosActionPerformed(evt);
            }
        });
        getContentPane().add(buttonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 130, 40));

        buttonRecursos.setText("Recursos");
        buttonRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecursosActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 130, 40));

        buttonClientes.setText("Clientes");
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 130, 40));

        buttonUsuarios.setText("Usuarios");
        buttonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 40));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel2.setText("Develop Guayana");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 450, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsuariosActionPerformed
        new VentanaUsuarios().setVisible(true);
    }//GEN-LAST:event_buttonUsuariosActionPerformed

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
       new VentanaClientes().setVisible(true);
    }//GEN-LAST:event_buttonClientesActionPerformed

    private void buttonRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecursosActionPerformed
        new VentanaRecursos().setVisible(true);
    }//GEN-LAST:event_buttonRecursosActionPerformed

    private void buttonProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProyectosActionPerformed
       new VentanaProyectos().setVisible(true);
    }//GEN-LAST:event_buttonProyectosActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonProyectos;
    private javax.swing.JButton buttonRecursos;
    private javax.swing.JButton buttonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

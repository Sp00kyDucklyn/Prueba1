/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.PersonaDAO;
import dominio.Persona;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class SeleccionTramite extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionTramite
     */
    public SeleccionTramite() {
        initComponents();
        //Necesito construir 4 botones
        //Dos paneles 
        
        txtRfcBuscar.setVisible(false);
        
        if(txtRfcBuscar.isShowing()){
            btnRenovacion.setVisible(false);
            btnRegistro.setVerifyInputWhenFocusTarget(false);
        }
        
        btnPersona.setVisible(false);
        btnVehiculo.setVisible(false);

        btnLicencia.setVisible(false);
        btnPlacas.setVisible(false);
    }
    
    public String buscarRfc(String rfc){
        //NO DEJAR QUE EL TXT SE PERMITAN ESCRIBIR CARACTERES NO ESPECIFICADOS FALTA
        //FORZAR AL USUARIO ESCRIBIR 13 CARACTERES LISTO
        if (txtRfcBuscar.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una palabra", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else if (!txtRfcBuscar.getText().contains("12")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese 13 carácteres", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }

        return rfc;
    }
    //Crear 2 paneles
    //Crear 4 botones 
    //Asignar acciones a los botones
//    public void initComponentsCustom(){
//        JButton btnPlacas = new JButton();
//        //C:\Users\hoshi\Documents\PruebaProyecto\Prueba1\PruebaP\src\main\resources\imagenesPantallas\placas.png
//        btnPlacas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenesPantallas/placas.png")));
//        
//        panOpciones.add(btnPlacas);
//    }
//    
//    public void mostrarBotones(){
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panOpciones = new javax.swing.JPanel();
        txtRfcBuscar = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        btnPlacas = new javax.swing.JButton();
        btnPersona = new javax.swing.JButton();
        btnLicencia = new javax.swing.JButton();
        btnVehiculo = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRenovacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panOpciones.setPreferredSize(new java.awt.Dimension(800, 600));
        panOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRfcBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRfcBuscarKeyTyped(evt);
            }
        });
        panOpciones.add(txtRfcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 220, 50));

        btnRegistro.setBorder(null);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
        });
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        panOpciones.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 200, 30));

        btnPlacas.setText("Placas");
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });
        panOpciones.add(btnPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        btnPersona.setText("Persona");
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        panOpciones.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        btnLicencia.setText("Licencia");
        btnLicencia.setToolTipText("");
        btnLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciaActionPerformed(evt);
            }
        });
        panOpciones.add(btnLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        btnVehiculo.setText("Vehiculo");
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });
        panOpciones.add(btnVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        btnVolver.setText("jButton1");
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panOpciones.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 30, 40));

        btnRenovacion.setBorder(null);
        btnRenovacion.setContentAreaFilled(false);
        btnRenovacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRenovacionMouseClicked(evt);
            }
        });
        btnRenovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovacionActionPerformed(evt);
            }
        });
        panOpciones.add(btnRenovacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Cuadro1 (1).png"))); // NOI18N
        panOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, -1));

        getContentPane().add(panOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 807, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         this.setVisible(false);
         MenuPrincipal menu = new MenuPrincipal();
         menu.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRenovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovacionActionPerformed
        // TODO add your handling code here:
        
               if (!btnRenovacion.isSelected()) {
            btnLicencia.setVisible(true);
            btnPlacas.setVisible(true);
        }


        
        
    }//GEN-LAST:event_btnRenovacionActionPerformed

    private void btnRenovacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRenovacionMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnRenovacionMouseClicked

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed
        // TODO add your handling code here:
        //Recordar poner buscar persona por rfc con joption
       
        if (!btnVehiculo.isSelected()) {

            txtRfcBuscar.setVisible(true);
            if (!buscarRfc(txtRfcBuscar.getText()).isEmpty()) {

                PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(txtRfcBuscar.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                    this.setVisible(false);
                    SiPlaca vehiculo = new SiPlaca(persona.get(0));
                    vehiculo.setVisible(true);
                    this.dispose();
                 }

            }

        }
     
    }//GEN-LAST:event_btnVehiculoActionPerformed

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        // TODO add your handling code here:
       
            
        
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:   
        
        if (!btnRegistro.isSelected()) {
            btnPersona.setVisible(true);
            
            btnVehiculo.setVisible(true);
        } 
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        RegistroPersona registro = new RegistroPersona();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
        // TODO add your handling code here:
         if (!btnPlacas.isSelected()) {

            txtRfcBuscar.setVisible(true);
            if (!buscarRfc(txtRfcBuscar.getText()).isEmpty()) {

                PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(txtRfcBuscar.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                    txtRfcBuscar.setVisible(true);
                    this.setVisible(false);
                    SiPlaca2 placa = new SiPlaca2();
                    placa.setVisible(true);
                    this.dispose();
                 }

            }
         }

    }//GEN-LAST:event_btnPlacasActionPerformed

    private void btnLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciaActionPerformed
        // TODO add your handling code here:
          if (!btnLicencia.isSelected()) {

            txtRfcBuscar.setVisible(true);
            if (!buscarRfc(txtRfcBuscar.getText()).isEmpty()) {

                PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(txtRfcBuscar.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                    txtRfcBuscar.setVisible(true);
                    this.setVisible(false);
                    SiLicencia licencia = new SiLicencia(persona.get(0));
                    licencia.setVisible(true);
                    this.dispose();
                 }

            }
         }
       
    }//GEN-LAST:event_btnLicenciaActionPerformed

    private void txtRfcBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRfcBuscarKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRfcBuscarKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SeleccionTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SeleccionTramite().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLicencia;
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRenovacion;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panOpciones;
    private javax.swing.JTextField txtRfcBuscar;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.LicenciaDAO;
import dao.PersonaDAO;
import dao.TramiteDAO;
import dao.VehiculoDAO;
import dominio.Licencia;
import dominio.Persona;
import dominio.Placa;
import dominio.Tramite;
import dominio.Vehiculo;
import interfaces.ITramiteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Pantalla del historial de placas
 * @author hoshi
 */
public class FrHistorialPlaca extends javax.swing.JFrame {

    /**
     * Creates new form FrHistorialPlaca
     */
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    Vehiculo vehiculo = new Vehiculo();
    Tramite tramite = new Tramite();
    //LicenciaDAO licenciaDAO = new LicenciaDAO();
    TramiteDAO tramiteDAO = new TramiteDAO();
    private List<Tramite> listaPDF;
    
    /**
     * Metodo constructor que recibe el vehiculo
     * @param vehiculo 
     */
    public FrHistorialPlaca(Vehiculo vehiculo) {
//        this.listaPDF = new ArrayList<Tramite>();

        initComponents();
        //this.persona = persona;
        this.vehiculo = vehiculo;
        lblRfc.setText(vehiculo.getPersona().getRfc());
        tramite.getPersona();
        personaDAO.desencriptarPersona(vehiculo.getPersona());
         String n = vehiculo.getPersona().getNombre() + " "
                        + vehiculo.getPersona().getApellidoP() + " " + vehiculo.getPersona().getApellidoM();
        lblNombrePersona.setText(n);
        buscarTramites();
    }
    
    /**
     * Metodo que busca los tramites de placas
     */
       public void buscarTramites(){
//        ITramiteDAO tramiteDAO = new TramiteDAO();
        listaPDF= tramiteDAO.listaTramiteL(tramite.getFechaExpedicion(), tramite.getFechaVencimiento(),tramite.getCosto(),tramite.getEstado());
        
//        List <Tramite> tramites2 = tramiteDAO.listaTramiteC(chLicencia.isSelected(), chLicencia.isSelected());
        
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        model.setRowCount(0);
        
        if (listaPDF != null) {
            for (int i = 0; i < listaPDF.size(); i++) {
                Object [] datos = new Object[model.getColumnCount()];
                if(personaDAO.buscarRfc(lblRfc.getText())!=null){
                    
                     if(listaPDF.get(i) instanceof Placa){
                    datos[0] = listaPDF.get(i).getFechaExpedicion();
                    datos[1] = listaPDF.get(i).getFechaVencimiento();
                    datos[2] = listaPDF.get(i).getEstado();
                    datos[3] = listaPDF.get(i).getCosto();
                    
                }
                    
                }
                
                model.addRow(datos);
            }
                
            
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
        tblResultados = new javax.swing.JTable();
        lblNombrePersona = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblRfc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Expedición", "Fecha Vencimiento", "Estado", "Costo"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 860, 440));
        getContentPane().add(lblNombrePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 350, 40));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 30));
        getContentPane().add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 220, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Consultas_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PersonaDAO personaDAO = new PersonaDAO();
                //PONER TXT.GETTEXT DENTRO DE DONDE ESTAN LAS COMILLAS AHORITA LISTO

                List<Persona> persona = personaDAO.buscarRfc(lblRfc.getText());

                if (persona.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No encontro el rfc");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "Se encontro el rfc");
                    this.setVisible(false);
                    FrmLicencia licencia = new FrmLicencia(persona.get(0));
                    licencia.setVisible(true);
                    this.dispose();
                 }
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(FrHistorialPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrHistorialPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrHistorialPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrHistorialPlaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrHistorialPlaca().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables
}

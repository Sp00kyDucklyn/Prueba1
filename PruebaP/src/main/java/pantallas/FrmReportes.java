/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dao.PersonaDAO;
import dao.TramiteDAO;
import dominio.JasperReporte;
import dominio.Licencia;
import dominio.Persona;
import dominio.Placa;
import dominio.Tramite;
import interfaces.IPersonaDAO;
import interfaces.ITramiteDAO;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Carmen & Raul
 */
public class FrmReportes extends javax.swing.JFrame {

    TramiteDAO tramiteDAO = new TramiteDAO();
    private List<Tramite> listaPDF;
    /**
     * Creates new form GeneracionReportes
     */
    public FrmReportes() {
        initComponents();
        this.listaPDF = new ArrayList<Tramite>();
        buscarTramites();
    }
    
    public void buscarTramites(){
        ITramiteDAO tramiteDAO = new TramiteDAO();
        listaPDF= tramiteDAO.listaTramite(txtFechaInicio.getDate(), txtFechaFin.getDate(),chLicencia.isSelected(), chPlaca.isSelected());
        
//        List <Tramite> tramites2 = tramiteDAO.listaTramiteC(chLicencia.isSelected(), chLicencia.isSelected());
        listaPDF = tramiteDAO.desencriptarPersonaTramite(listaPDF);
        
        if (!txtNombre.getText().equals("")) {

            List<Tramite> listaNombre = new ArrayList<Tramite>();

            for (Tramite t : listaPDF) {
                Persona persona = t.getPersona();
                String n = persona.getNombre() + " "
                        + persona.getApellidoP() + " " + persona.getApellidoM();
                if (n.toLowerCase().contains(txtNombre.getText().toLowerCase())) {
                    listaNombre.add(t);
                }

            }
            
            listaPDF = listaNombre;
            

        }
        
        
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        model.setRowCount(0);
        
        if (listaPDF != null) {
            for (int i = 0; i < listaPDF.size(); i++) {
                Object [] datos = new Object[model.getColumnCount()];
                if(listaPDF.get(i) instanceof Licencia){
                    datos[0] = "licencia";
                }
                if(listaPDF.get(i) instanceof Placa){
                    datos[0] = "placa";
                    
                }
                
                datos[1] = listaPDF.get(i).getFechaExpedicion();
                Persona persona = listaPDF.get(i).getPersona();
                String n = persona.getNombre() + " "
                        + persona.getApellidoP() + " " + persona.getApellidoM();
                datos[2]= n;
                datos [3] = listaPDF.get(i).getCosto();
                
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

        jPanel1 = new javax.swing.JPanel();
        btnGenerarReporte = new javax.swing.JButton();
        chLicencia = new javax.swing.JCheckBox();
        btnRegresarMenu = new javax.swing.JButton();
        btnBuscarReportes = new javax.swing.JButton();
        chPlaca = new javax.swing.JCheckBox();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/Group 6.png"))); // NOI18N
        btnGenerarReporte.setBorder(null);
        btnGenerarReporte.setContentAreaFilled(false);
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 80, 60));

        chLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chLicenciaActionPerformed(evt);
            }
        });
        jPanel1.add(chLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, -1, -1));

        btnRegresarMenu.setBorder(null);
        btnRegresarMenu.setContentAreaFilled(false);
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 40, 30));

        btnBuscarReportes.setBorder(null);
        btnBuscarReportes.setContentAreaFilled(false);
        btnBuscarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 30, 30));
        jPanel1.add(chPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));
        jPanel1.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 140, 20));
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 150, 20));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo trámite", "Fecha", "Nombre", "Costo"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 860, 430));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 410, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesPantallas/GeneraciónReportes (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMenuActionPerformed

    private void chLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chLicenciaActionPerformed

    private void btnBuscarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarReportesActionPerformed
        // TODO add your handling code here:
        buscarTramites();
    }//GEN-LAST:event_btnBuscarReportesActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de ejecutar este comando?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<JasperReporte> pdf = new ArrayList<JasperReporte>();
            if (listaPDF.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La tabla esta vacia");
                return;
            }
            for (Tramite tramite : listaPDF) {
                 JasperReporte reporte = new JasperReporte();
                 Persona persona = tramite.getPersona();
                 String nombreCompleto = persona.getNombre()+" "+persona.getApellidoP()+" "+persona.getApellidoM();
                if (tramite instanceof Placa) {
                    reporte.setTipoTramite("placa");
                }
                if (tramite instanceof Licencia) {
                    reporte.setTipoTramite("licencia");
                }else{
                    reporte.setTipoTramite("sabradios");
                }

                reporte.setNombre(nombreCompleto);
                reporte.setCosto(String.valueOf(tramite.getCosto()));
                reporte.setPeriodo(tramite.getFechaExpedicion().toString());
                
                pdf.add(reporte);
            }
            try {
                
                Map parametro = new HashMap();
                
                LocalDateTime fechaHoraActual = LocalDateTime.now();
                DateTimeFormatter formatEscrito = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, hh:mm a");
                String fechaHoraEscrita = fechaHoraActual.format(formatEscrito);
                parametro.put("fecha_generacion",fechaHoraEscrita);
                
                parametro.put("historial", "Reporte General");
                
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(pdf);

                // Cargar el archivo JRXML del reporte
                InputStream reportFile = getClass().getResourceAsStream("/reportePDF_1.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,  parametro, beanColDataSource);

                // Visualizar el reporte
                JasperExportManager.exportReportToPdfFile(jasperPrint, "./reporteTramites.pdf");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

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
//            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmReportes().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarReportes;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JCheckBox chLicencia;
    private javax.swing.JCheckBox chPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

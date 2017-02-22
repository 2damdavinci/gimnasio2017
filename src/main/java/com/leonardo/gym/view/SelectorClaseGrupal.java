/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.gym.view;

import com.leonardo.gym.dao.ClasesGrupalesDAO;
import com.leonardo.gym.dao.HorariosClasesGrupalesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Tab;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.leonardo.gym.model.ClaseGrupal;
import com.leonardo.gym.model.DetalleClasesGrupales;
import com.leonardo.gym.model.HorarioClaseGrupal;
import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gabri
 */
public class SelectorClaseGrupal extends javax.swing.JFrame {

    /**
     * Creates new form BuscadorClienteClaseGrupal
     */
    DefaultTableModel modelo, modelo1;
    ResultSet rs, rs1;
    ClasesGrupalesDAO clase = new ClasesGrupalesDAO();
    HorariosClasesGrupalesDAO horario = new HorariosClasesGrupalesDAO();
    ClaseGrupal c;
    String reportSource = "./src/main/java/com/leonardo/gym/informes/informeClasesGrupales.jrxml";
    String reportSource1 = "./src/main/java/com/leonardo/gym/informes/informeHorarios.jrxml";
    Map parametros = new HashMap();
    JasperReport reporte;
    String ruta;

    public SelectorClaseGrupal() {
        initComponents();
        modelo = (DefaultTableModel) tabClases.getModel();
        modelo1 = (DefaultTableModel) tabHorario.getModel();
        tabClases.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    btnAñadir1.setEnabled(true);
                    btnModificar1.setEnabled(true);
                    btnEliminar1.setEnabled(true);
                    btnInforme2.setEnabled(true);
                    ClaseGrupal cl = new ClaseGrupal();
                    cl.setId(Integer.parseInt(tabClases.getValueAt(tabClases.getSelectedRow(), 0).toString()));
                    cl.setNombre(tabClases.getValueAt(tabClases.getSelectedRow(), 1).toString());
                    RecargarTablaHorarios(cl);
                }
            }

        });
        tabHorario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    DetalleClasesGrupales de = new DetalleClasesGrupales();
                    de.setId_horario(Integer.parseInt((tabHorario.getValueAt(tabHorario.getSelectedRow(), 0)).toString()));
                    //System.out.println(de.getId_horario());
                    Component component = (Component) e.getSource();
                    JFrame frame = (JFrame) SwingUtilities.getRoot(component);

                    jDetalle = new DetallesHorario(frame, true);
                    jDetalle.setDe(de);
                    jDetalle.RecargarTablaDetalles();
                    jDetalle.setVisible(true);
                }
            }

        });
        RecargarTablaClase();
    }

    public void RecargarTablaClase() {
        for (int i = 0; i < tabClases.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        rs = clase.ReturnClase();

        try {

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_clase"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("aforo")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectorClaseGrupal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RecargarTablaHorarios(ClaseGrupal clase) {
        c = clase;
        for (int i = 0; i < tabHorario.getRowCount(); i++) {
            modelo1.removeRow(i);
            i -= 1;
        }
        rs1 = horario.ReturnHorarioClase(clase);

        try {

            while (rs1.next()) {
                modelo1.addRow(new Object[]{rs1.getInt("id_horario"), rs1.getString("profesor"), rs1.getString("fecha"), rs1.getString("hora"), rs1.getInt("plazasLibres")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectorClaseGrupal.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabClases = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabHorarios = new javax.swing.JScrollPane();
        tabHorario = new javax.swing.JTable();
        btnAñadir1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();
        btnInforme2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clases Grupales"));

        jLabel2.setText("Seleccione la clase grupal deseada:");

        tabClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nombre", "Descripción", "Aforo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabClases.setToolTipText("doble click para ver los horarios");
        jScrollPane1.setViewportView(tabClases);

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnInforme.setText("Generar Informe");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAñadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInforme)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadir)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnInforme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario Clase"));

        jLabel1.setText("Seleccione el horario deseado:");

        tabHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Profesor", "Fecha", "Hora", "Plazas libres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabHorarios.setViewportView(tabHorario);

        btnAñadir1.setText("Añadir");
        btnAñadir1.setEnabled(false);
        btnAñadir1.setFocusable(false);
        btnAñadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.setEnabled(false);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnModificar1.setText("Modificar");
        btnModificar1.setEnabled(false);
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnInforme2.setText("Generar Informe");
        btnInforme2.setEnabled(false);
        btnInforme2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInforme2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tabHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAñadir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInforme2)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadir1)
                    .addComponent(btnEliminar1)
                    .addComponent(btnModificar1)
                    .addComponent(btnInforme2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(tabHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        jclase = new AñadirClase(this, true);
        jclase.setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabClases.getSelectedRow() > -1) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar la clase: " + tabClases.getValueAt(tabClases.getSelectedRow(), 1).toString(), "ATENCION", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {

                int id, aforo, fila;
                String nombre, descripcion;
                fila = tabClases.getSelectedRow();
                id = Integer.parseInt(tabClases.getValueAt(fila, 0).toString());
                nombre = tabClases.getValueAt(fila, 1).toString();
                descripcion = tabClases.getValueAt(fila, 2).toString();
                aforo = Integer.parseInt(tabClases.getValueAt(fila, 0).toString());

                ClaseGrupal clasedelete = new ClaseGrupal(id, nombre, descripcion, aforo);

                clase.EliminarClase(clasedelete);
                RecargarTablaClase();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar la clase que desee eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tabClases.getSelectedRow() > -1) {
            String nombre, descripcion, aforo, id;
            id = tabClases.getValueAt(tabClases.getSelectedRow(), 0).toString();
            nombre = tabClases.getValueAt(tabClases.getSelectedRow(), 1).toString();
            descripcion = tabClases.getValueAt(tabClases.getSelectedRow(), 2).toString();
            aforo = tabClases.getValueAt(tabClases.getSelectedRow(), 3).toString();
            ClaseGrupal claseupdate = new ClaseGrupal(Integer.parseInt(id), nombre, descripcion, Integer.parseInt(aforo));
            jclase = new AñadirClase(this, true);
            jclase.ActualizarTextos(claseupdate);
            jclase.setEsInsercion(false);
            jclase.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar la clase que desee modificar");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAñadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir1ActionPerformed
        jHorario = new AñadirHorario(this, true);
        jHorario.setClase(c);
        jHorario.setVisible(true);
    }//GEN-LAST:event_btnAñadir1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        if (tabHorario.getSelectedRow() > -1) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar la clase con fecha: " + tabHorario.getValueAt(tabClases.getSelectedRow(), 2).toString(), "ATENCION", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {

                int id, fila;

                fila = tabHorario.getSelectedRow();
                id = Integer.parseInt(tabHorario.getValueAt(fila, 0).toString());

                HorarioClaseGrupal horariodelete = new HorarioClaseGrupal();
                horariodelete.setId(id);

                horario.EliminarHorario(horariodelete);
                RecargarTablaHorarios(c);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar el horario que desee eliminar");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        if (tabHorario.getSelectedRow() > -1) {
            String profesor, fecha, hora, id;
            id = tabHorario.getValueAt(tabHorario.getSelectedRow(), 0).toString();
            profesor = tabHorario.getValueAt(tabHorario.getSelectedRow(), 1).toString();
            fecha = tabHorario.getValueAt(tabHorario.getSelectedRow(), 2).toString();
            String aux[] = fecha.split("/");
            fecha = aux[2] + "/" + aux[1] + "/" + aux[0];
            hora = tabHorario.getValueAt(tabHorario.getSelectedRow(), 3).toString();
            System.out.println(fecha);
            System.out.println(new Date(fecha));
            HorarioClaseGrupal horarioupdate = new HorarioClaseGrupal(Integer.parseInt(id), 0, 0, profesor, new Date(fecha), hora);
            jHorario = new AñadirHorario(this, true);
            jHorario.actualizar(horarioupdate);
            jHorario.setClase(c);
            jHorario.setEsInsercion(false);
            jHorario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar el horario que desee modificar");
        }
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
   if (tabClases.getSelectedRow() > -1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");

            parametros.put("ID_CLASE", Long.parseLong(tabClases.getValueAt(tabClases.getSelectedRow(), 0).toString()));

            reporte = (JasperReport) JasperCompileManager.compileReport(reportSource);

            JasperPrint miInforme = JasperFillManager.fillReport(reporte, parametros, conexion);

            JasperViewer.viewReport(miInforme,false);
            

        } catch (ClassNotFoundException e) {
            System.out.println("error driver");
        } catch (SQLException e) {
            System.out.println("Error sentencia SQL");
        } catch (JRException ex) {
            System.out.println(ex);
        }} else {
              JOptionPane.showMessageDialog(null, "Tiene que seleccionar una clase");
        }
    }//GEN-LAST:event_btnInformeActionPerformed

    private void btnInforme2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInforme2ActionPerformed
          if (tabHorario.getSelectedRow() > -1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://db4free.net:3307/gimnasio", "davinci", "dam2davinci");

            parametros.put("ID_HORARIO", Long.parseLong(tabClases.getValueAt(tabHorario.getSelectedRow(), 0).toString()));

            reporte = (JasperReport) JasperCompileManager.compileReport(reportSource1);

            JasperPrint miInforme = JasperFillManager.fillReport(reporte, parametros, conexion);

            JasperViewer.viewReport(miInforme,false);
            

        } catch (ClassNotFoundException e) {
            System.out.println("error driver");
        } catch (SQLException e) {
            System.out.println("Error sentencia SQL");
        } catch (JRException ex) {
            System.out.println(ex);
        }} else {
              JOptionPane.showMessageDialog(null, "Tiene que seleccionar un horario");
        }
    }//GEN-LAST:event_btnInforme2ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectorClaseGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectorClaseGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectorClaseGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectorClaseGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectorClaseGrupal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnAñadir1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnInforme2;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabClases;
    private javax.swing.JTable tabHorario;
    private javax.swing.JScrollPane tabHorarios;
    // End of variables declaration//GEN-END:variables
    AñadirClase jclase;
    DetallesHorario jDetalle;
    AñadirHorario jHorario;
}

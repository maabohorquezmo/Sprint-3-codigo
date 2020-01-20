package Frontera.Estadisticas;

import Control.Estadisticas;
import Control.GestionDeEmpleados;
import Entidad.Cliente;
import Entidad.Empleado;
import Entidad.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ConsultasRanking extends javax.swing.JPanel {

    DefaultTableModel model;

    public ConsultasRanking() {
        initComponents();
        model = (DefaultTableModel) resultadoRanking.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoConsulta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoRanking = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ventas Empleados", "Compras Clientes" }));
        tipoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoConsultaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione el tipo de consulta:");

        resultadoRanking.setAutoCreateRowSorter(true);
        resultadoRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cedula", "Transacciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultadoRanking.setRowSorter(resultadoRanking.getRowSorter());
        jScrollPane1.setViewportView(resultadoRanking);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoConsultaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (tipoConsulta.getSelectedItem().equals("Ventas Empleados")) {

            model.setRowCount(0);
            Estadisticas ver = new Estadisticas();
            List<Empleado> lista = ver.edao.leerEMP();
            for (Empleado b : lista) {
                model.insertRow(model.getRowCount(), new Object[]{b.getNombre() + " " + b.getApellido(), b.getCedula(), ver.consultaIndividualEMP(Integer.toString(b.getCedula()))});
            }
            resultadoRanking.setAutoCreateRowSorter(true);

        } else if (tipoConsulta.getSelectedItem().equals("Compras Clientes")) {
            model.setRowCount(0);
            Estadisticas ver = new Estadisticas();
            List<Cliente> lista = ver.cdao.leerCLIENT();
            for (Cliente b : lista) {
                model.insertRow(model.getRowCount(), new Object[]{b.getNombre() + " " + b.getApellido(), b.getCedula(), ver.consultaIndividualCLIENT(Integer.toString(b.getCedula()))});
            }
            resultadoRanking.setAutoCreateRowSorter(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultadoRanking;
    private javax.swing.JComboBox<String> tipoConsulta;
    // End of variables declaration//GEN-END:variables
}

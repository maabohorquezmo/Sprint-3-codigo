package Frontera.Ventas;

import Control.GestionDeProductos;
import Entidad.Producto;
import Entidad.Recibo;
import Entidad.Sistema;
import Frontera.Inicio;
import Control.GestionDeProductos;
import Control.Ventas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Venta extends javax.swing.JPanel {

    DefaultTableModel model;
    DefaultTableModel carrito;
    public ArrayList<Producto> lista_carrito = new ArrayList();

    public Venta() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
        carrito = (DefaultTableModel) table2.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        consultarP1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        consultaCategoria1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        recibox = new javax.swing.JLabel();
        empleadox = new javax.swing.JLabel();
        resultado = new javax.swing.JLabel();
        resultado_anadir = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JLabel();
        advertencia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setForeground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Productos disponibles");

        consultarP1.setText("Consultar");
        consultarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarP1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoría");

        consultaCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Combustible", "Refrigerantes", "Aceites", "Lubricantes" }));
        consultaCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCategoria1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Valor Uni.", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel3.setText("Ingrese ID");

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad de unidades");

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        jButton1.setText(" Añadir al carrito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Valor Uni.", "Cantidad","Categoria"
            }
        ));
        jScrollPane3.setViewportView(table2);

        jButton2.setText("Vender");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("RECIBO");

        jLabel6.setText("Precio de la venta:");

        jLabel7.setText("Empleado:");

        recibox.setText("         ");

        empleadox.setText("       ");

        resultado.setText("           ");

        jLabel8.setText("Cedula:");

        jLabel9.setText("Cliente:");

        nombreCliente.setText("    ");

        advertencia.setText("    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultado_anadir)
                .addGap(560, 560, 560))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(consultarP1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultaCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cedula))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(recibox))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(58, 58, 58)
                                            .addComponent(empleadox))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(76, 76, 76)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton2)
                                                .addComponent(jLabel5))))
                                    .addGap(123, 123, 123)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(nombreCliente))))
                    .addComponent(resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(consultaCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(consultarP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(resultado_anadir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(recibox))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(empleadox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(nombreCliente))
                                .addGap(172, 172, 172))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(resultado)
                        .addGap(18, 18, 18)
                        .addComponent(advertencia)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarP1ActionPerformed
        GestionDeProductos ver = new GestionDeProductos();
        model.setRowCount(0);
        String a = (String) consultaCategoria1.getSelectedItem();
        Producto x = new Producto();
        x.setCategoria(a);
        List<Producto> lista = ver.pdao.leerCAT(x);
        for (Producto b : lista) {
            model.insertRow(model.getRowCount(), new Object[]{b.getId(), b.getNombre(), b.getValor(), b.getCantidad()});
        }
    }//GEN-LAST:event_consultarP1ActionPerformed

    private void consultaCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaCategoria1ActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ventas ver = new Ventas();
        carrito.setRowCount(0);
        String text = ID.getText();
        String text2 = cantidad.getText();
        int a = Integer.parseInt(ID.getText());
        int b = Integer.parseInt(cantidad.getText());
        Producto x = new Producto();
        x.setId(a);
        Producto transicion = ver.pdao.leerID(x);

        if (ver.verificarDatos(text, text2).equals("")) {
            if (ver.anadirAlCarro(text, text2).equals("Producto encontrado")) {
                resultado_anadir.setText("Producto encontrado");
                transicion.setCantidad(b);
                lista_carrito.add(transicion);
                for (Producto c : lista_carrito) {
                    carrito.insertRow(carrito.getRowCount(), new Object[]{c.getId(), c.getNombre(), c.getValor(), c.getCantidad(), c.getCategoria()});
                }
            } else if (ver.anadirAlCarro(text, text2).equals("No hay suficientes unidades para vender")) {
                for (Producto c : lista_carrito) {
                    carrito.insertRow(carrito.getRowCount(), new Object[]{c.getId(), c.getNombre(), c.getValor(), c.getCantidad(), c.getCategoria()});
                }
                resultado_anadir.setText("No hay suficientes unidades para vender");
            }
        } else {
            resultado_anadir.setText(ver.verificarDatos(text, text2));
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed

    }//GEN-LAST:event_IDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ventas ver = new Ventas();
        Recibo recibo = new Recibo();
        resultado.setText("");
        
        if (!lista_carrito.isEmpty()) {
            if (cedula.getText().length() == 0) {
                ArrayList<String> res = new ArrayList<String>();
                res = ver.venderNoCedula(lista_carrito);
                System.out.println(res.get(0));
                recibox.setText(res.get(0));
                empleadox.setText(res.get(1));
                nombreCliente.setText(res.get(2));
                resultado.setText(res.get(3));
                advertencia.setText(res.get(4));
                lista_carrito.clear();
            }else{
                ArrayList<String> res = new ArrayList<String>();
                res = ver.venderCedula(lista_carrito, cedula.getText());
                recibox.setText(res.get(0));
                empleadox.setText(res.get(1));
                nombreCliente.setText(res.get(2));
                resultado.setText(res.get(3));
                advertencia.setText(res.get(4));
                lista_carrito.clear();
            }

        } else {
            resultado.setText("No se ha añadido ningún articulo al carrito");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel advertencia;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cedula;
    private javax.swing.JComboBox<String> consultaCategoria1;
    private javax.swing.JButton consultarP1;
    private javax.swing.JLabel empleadox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nombreCliente;
    private javax.swing.JLabel recibox;
    private javax.swing.JLabel resultado;
    private javax.swing.JLabel resultado_anadir;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}

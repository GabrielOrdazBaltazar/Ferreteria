/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package vistas;

import Control.Validaciones;

/**
 *
 * @author tachy
 */
public class DescuentoVistaBuscar extends javax.swing.JFrame {

    /** Creates new form DescuentoVistaBuscar */
    public DescuentoVistaBuscar() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDescuentoClienteFrecuente = new javax.swing.JTextField();
        txtMinCompra = new javax.swing.JTextField();
        txtDescuentoVolumen = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jResultado = new javax.swing.JLabel();
        
        //Validacion Id Departamento
        Validaciones val = new Validaciones();
        val.validacionSoloNum(txtId, 11, jResultado);
       
        //Validacion minimo de compra
        val.validacionSoloNum(txtMinCompra, 5, jResultado);
        
        //Validacion Descuento Cliente Frecuente
        val.validacionSoloNum(txtDescuentoClienteFrecuente, 3, jResultado);
        
      //Validacion Descuento Cliente Frecuente
        val.validacionSoloNum(txtDescuentoVolumen, 3, jResultado);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar descuento ");

        jLabel2.setText("Descuento cliente frecuente :");

        jLabel3.setText("Min compra :");

        jLabel4.setText("ID :");

        jLabel5.setText("Descuento por volumen :");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtDescuentoClienteFrecuente, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(txtMinCompra)
                            .addComponent(txtDescuentoVolumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescuentoClienteFrecuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMinCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescuentoVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int id = Integer.parseInt(txtId.getText());
        paquete1.DescuentoSQL des = new paquete1.DescuentoSQL();
        paquete1.Descuento des1 = new paquete1.Descuento();
        des1 = des.buscarDescuento(id);
        //Mostrar resultado
        txtDescuentoClienteFrecuente.setText(String.valueOf(des1.getDescuento_ClienteFrecuente()));
        txtDescuentoVolumen.setText(String.valueOf(des1.getDescuento_volumen()));
        txtId.setText(String.valueOf(des1.getId_descuento()));
        txtMinCompra.setText(String.valueOf(des1.getMinCompra())); 
        jResultado.setText(des1.getResultado());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Limpiar resultado
        txtDescuentoClienteFrecuente.setText("");
        txtDescuentoVolumen.setText("");
        txtId.setText("");
        txtMinCompra.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Vaiables 
        int id_descuento = Integer.parseInt(txtId.getText());
        int descuentoClienteFrecuente = Integer.parseInt(txtDescuentoClienteFrecuente.getText());
        double minCompra = Double.parseDouble(txtMinCompra.getText());
        int descuentoVolumen = Integer.parseInt(txtDescuentoVolumen.getText());  
        //Objetos
        paquete1.Descuento des = new paquete1.Descuento();
        paquete1.DescuentoSQL des1 = new paquete1.DescuentoSQL();
        
        des.setId_descuento(id_descuento);
        des.setDescuento_ClienteFrecuente(descuentoClienteFrecuente);
        des.setMinCompra(minCompra);
        des.setDescuento_volumen(descuentoVolumen);
        
        String Res = des1.actualizarDescuento(id_descuento, descuentoClienteFrecuente, minCompra, descuentoVolumen);
        jResultado.setText(Res);
        //Limpiar resultado
        txtDescuentoClienteFrecuente.setText("");
        txtDescuentoVolumen.setText("");
        txtId.setText("");
        txtMinCompra.setText("");        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminar
        //Variables
        int id = Integer.parseInt(txtId.getText());
        int descuentoClienteFrecuente = Integer.parseInt(txtDescuentoClienteFrecuente.getText());
        double minCompra = Double.parseDouble(txtMinCompra.getText());
        int descuentoVolumen = Integer.parseInt(txtDescuentoVolumen.getText());
        
        paquete1.DescuentoSQL des = new paquete1.DescuentoSQL();
        String Res = des.eliminarDescuento(id);
        jResultado.setText(Res);
        //Limpiar resultado
        txtDescuentoClienteFrecuente.setText("");
        txtDescuentoVolumen.setText("");
        txtId.setText("");
        txtMinCompra.setText("");        
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescuentoVistaBuscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jResultado;
    private javax.swing.JTextField txtDescuentoClienteFrecuente;
    private javax.swing.JTextField txtDescuentoVolumen;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMinCompra;
    // End of variables declaration//GEN-END:variables

}

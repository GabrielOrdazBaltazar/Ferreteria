
package vistas;

import javax.swing.JOptionPane;
import paquete1.EmpleadoSQL;

public class LoginEmpleado extends javax.swing.JFrame {

    public LoginEmpleado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

      //Validaciones
        Validaciones val = new Validaciones();
        
        val.validacionSoloNum(txtIdEmpleado, 11, jResultado);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LOGGIN EMPLEADO");

        jLabel2.setText("Clave Empleado :");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //Boton Loggin
        int id_empleado = Integer.parseInt(txtIdEmpleado.getText());
        
        EmpleadoSQL emp = new EmpleadoSQL();
        
        switch(emp.buscarEmpleado(id_empleado).getId_departamento().getId_departamento()){
            case  1234:
                JOptionPane.showMessageDialog(null, "Bienvenido "+emp.buscarEmpleado(id_empleado).getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
                
                vistas.Compras comp = new vistas.Compras();
                comp.setVisible(true);
                comp.setLocationRelativeTo(null); 
                this.setVisible(false);
            break;    
        
            case  1235:
                JOptionPane.showMessageDialog(null, "Bienvenido "+emp.buscarEmpleado(id_empleado).getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            break; 
            
            case  1236:
                JOptionPane.showMessageDialog(null, "Bienvenido "+emp.buscarEmpleado(id_empleado).getNombre(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                vistas.RecursosHumanos recHum = new vistas.RecursosHumanos();
                recHum.setVisible(true);
                recHum.setLocationRelativeTo(null); 
                this.setVisible(false);            
            break; 
            
            default:
                JOptionPane.showMessageDialog(null, "La clave Ingresada no existe", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            break;     
        
        }
        
        //Limpiar panel
        txtIdEmpleado.setText("");
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LoginEmpleado logEmp = new LoginEmpleado();
        logEmp.setVisible(true);
        logEmp.setLocationRelativeTo(null);
        this.setVisible(false);
        
       
        logEmp.setVisible(true);
        logEmp.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtIdEmpleado;
    // End of variables declaration//GEN-END:variables
}

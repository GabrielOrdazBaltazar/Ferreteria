package Vistas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Clases.Almacen;
import Clases.AlmacenSQL;
import Clases.Conexion;


import java.sql.Connection;


public class V_Almacen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idSucursal;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			V_Almacen dialog = new V_Almacen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public V_Almacen(Conexion con) {
		this.con = con;
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		
		setBounds(100, 100, 460, 232);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelAlmacen = new JPanel();
			contentPanel.add(panelAlmacen);
			
			JLabel label_Almacen = new JLabel("Ingrese Almacen");
			label_Almacen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel label_idSucursal = new JLabel("ID Sucursal:");
			label_idSucursal.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			idSucursal = new JTextField();
			idSucursal.setColumns(10);
			
			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Guardar(evt);
				}
			});
			btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Buscar(evt);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnRegistros = new JButton("Ver Registros");
			btnRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					VerTabla(evt);
				}
			});
			btnRegistros.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			GroupLayout gl_panelAlmacen = new GroupLayout(panelAlmacen);
			gl_panelAlmacen.setHorizontalGroup(
				gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelAlmacen.createSequentialGroup()
						.addGap(23)
						.addComponent(label_idSucursal)
						.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
							.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addComponent(btnGuardar, Alignment.TRAILING))
						.addContainerGap(27, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_panelAlmacen.createSequentialGroup()
						.addContainerGap(296, Short.MAX_VALUE)
						.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(gl_panelAlmacen.createSequentialGroup()
						.addGap(132)
						.addComponent(label_Almacen)
						.addContainerGap(144, Short.MAX_VALUE))
			);
			gl_panelAlmacen.setVerticalGroup(
				gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelAlmacen.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_Almacen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_idSucursal)
							.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGuardar))
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(btnBuscar)
						.addGap(11)
						.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			panelAlmacen.setLayout(gl_panelAlmacen);
		}
	}
	
	private void Guardar(ActionEvent evt) { //java.awt.event.
    	try {
    		int id_sucursal;
    		id_sucursal = Integer.parseInt(this.idSucursal.getText());
    		
        	if (id_sucursal == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Almacen almacen = new Almacen(con, 1, id_sucursal);
    			this.idSucursal.setText("");
    		}
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Buscar(ActionEvent evt) {
		try {
			ModAlmacen editAlmacen = new ModAlmacen(con);
	    	editAlmacen.setLocation(450, 500);
	    	editAlmacen.setVisible(true);
	    	this.dispose();
		} catch (Exception e) {
			System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void VerTabla(ActionEvent evt) {
    	try {
    		
    	} catch (Exception e) {
			System.out.println(" Error: "+e.getMessage());
		}
    }
}

package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Clases.Almacen;
import Clases.Conexion;
import Clases.Sucursal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModAlmacen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idAlmacen;
	private JTextField idSucursal;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			ModAlmacen dialog = new ModAlmacen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public ModAlmacen(Conexion con) {
		this.con = con;	
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		
		setBounds(100, 100, 450, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelAlmacen = new JPanel();
			contentPanel.add(panelAlmacen);
			
			JLabel label_idAlmacen = new JLabel("ID Almacen:");
			label_idAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_idSucursal = new JLabel("ID Sucursal:");
			label_idSucursal.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			idAlmacen = new JTextField();
			idAlmacen.setColumns(10);
			idSucursal = new JTextField();
			idSucursal.setColumns(10);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Buscar(evt);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Limpiar(evt);
				}
			});
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));		
			
			JButton btnActualilzar = new JButton("Actualizar");
			btnActualilzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Actualizar(evt);
				}
			});
			btnActualilzar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Eliminar(evt);
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnRegistros = new JButton("Ver Registros");
			btnRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					VerTabla(evt);
				}
			});
			btnRegistros.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_Almacen = new JLabel("Almacen");
			label_Almacen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			GroupLayout gl_panelAlmacen = new GroupLayout(panelAlmacen);
			gl_panelAlmacen.setHorizontalGroup(
				gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
					.addGap(0, 415, Short.MAX_VALUE)
					.addGroup(gl_panelAlmacen.createSequentialGroup()
						.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelAlmacen.createSequentialGroup()
								.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelAlmacen.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
											.addComponent(label_idAlmacen)
											.addComponent(label_idSucursal))
										.addGap(18)
										.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
											.addComponent(idAlmacen, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
											.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panelAlmacen.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnActualilzar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelAlmacen.createSequentialGroup()
								.addGap(173)
								.addComponent(label_Almacen)))
						.addContainerGap(19, Short.MAX_VALUE))
			);
			gl_panelAlmacen.setVerticalGroup(
				gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
					.addGap(0, 233, Short.MAX_VALUE)
					.addGroup(gl_panelAlmacen.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_Almacen)
						.addGap(18)
						.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelAlmacen.createSequentialGroup()
								.addComponent(btnBuscar)
								.addGap(18)
								.addComponent(btnLimpiar)
								.addGap(18)
								.addComponent(btnActualilzar)
								.addGap(18)
								.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelAlmacen.createSequentialGroup()
								.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_idAlmacen)
									.addComponent(idAlmacen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panelAlmacen.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_idSucursal)
									.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(17, Short.MAX_VALUE))
			);
			panelAlmacen.setLayout(gl_panelAlmacen);
		}
	}
	
	private void Buscar(ActionEvent evt) {//java.awt.event.
		try {
			int id_almacen;
    		id_almacen = Integer.parseInt(this.idAlmacen.getText());
    		
    		if(id_almacen == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Almacen almacen = new Almacen(3, con, id_almacen);
    			
    			this.idSucursal.setText(String.valueOf(almacen.getId_sucursal()));
    		}
		} catch (Exception e) {
			System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Limpiar(ActionEvent evt) { 
    	try {
    		this.idAlmacen.setText("");
    		this.idSucursal.setText("");
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Actualizar(ActionEvent evt) { 
    	try {
    		int id_almacen, id_sucursal;
    		id_almacen = Integer.parseInt(this.idAlmacen.getText());
    		
        	if (id_almacen == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			id_sucursal = Integer.parseInt(idSucursal.getText());
    			
    			Almacen almacen = new Almacen(con, 5, id_almacen, id_sucursal);
    		}
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Eliminar(ActionEvent evt) { 
    	try {
    		int id_almacen;
    		id_almacen = Integer.parseInt(this.idAlmacen.getText());
    		
        	if (id_almacen == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Almacen almacen = new Almacen( 4,con, id_almacen);
    			
    			this.idAlmacen.setText("");
        		this.idSucursal.setText("");
    		}
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

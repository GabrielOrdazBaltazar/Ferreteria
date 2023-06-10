package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Almacen;
import Clases.Conexion;
import Clases.Sucursal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;

public class ModSucursal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idDireccion;
	private JTextField idSucursal;
	private JTextField nombre;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			ModSucursal dialog = new ModSucursal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public ModSucursal(Conexion con) {
		this.con = con;	
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		setBounds(100, 100, 453, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelSucursal = new JPanel();
			contentPanel.add(panelSucursal);
			
			JLabel label_idSucursal = new JLabel("ID Sucursal:");
			label_idSucursal.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_idDireccion = new JLabel("ID Direccion:");
			label_idDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_nombre = new JLabel("Nombre:");
			label_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			idDireccion = new JTextField();
			idDireccion.setColumns(10);
			idSucursal = new JTextField();
			idSucursal.setColumns(10);
			nombre = new JTextField();
			nombre.setColumns(10);
			
			JButton btnRegistros = new JButton("Ver Registros");
			btnRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					VerTabla(evt);
				}
			});
			btnRegistros.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Eliminar(evt);
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
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
			
			JButton btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Actualizar(evt);
				}
			});
			btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_Sucursal = new JLabel("Sucursal");
			label_Sucursal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			GroupLayout gl_panelSucursal = new GroupLayout(panelSucursal);
			gl_panelSucursal.setHorizontalGroup(
				gl_panelSucursal.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 417, Short.MAX_VALUE)
					.addGroup(gl_panelSucursal.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelSucursal.createSequentialGroup()
								.addGroup(gl_panelSucursal.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label_idSucursal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_idDireccion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_nombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
								.addGroup(gl_panelSucursal.createParallelGroup(Alignment.LEADING)
									.addComponent(idDireccion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
									.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
									.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
								.addGap(18))
							.addGroup(gl_panelSucursal.createSequentialGroup()
								.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.LEADING)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE))
					.addGroup(gl_panelSucursal.createSequentialGroup()
						.addContainerGap(172, Short.MAX_VALUE)
						.addComponent(label_Sucursal)
						.addGap(171))
			);
			gl_panelSucursal.setVerticalGroup(
				gl_panelSucursal.createParallelGroup(Alignment.LEADING)
					.addGap(0, 231, Short.MAX_VALUE)
					.addGroup(gl_panelSucursal.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_Sucursal)
						.addGap(18)
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_idSucursal)
							.addComponent(idSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_idDireccion)
							.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(idDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_nombre)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelSucursal.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(15, Short.MAX_VALUE))
			);
			panelSucursal.setLayout(gl_panelSucursal);
		}
	}
	
	private void Buscar(ActionEvent evt) {//java.awt.event.
		try {
			int id_sucursal;
    		id_sucursal = Integer.parseInt(idSucursal.getText());
    		
    		if(id_sucursal == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Sucursal sucursal = new Sucursal(con, 3, id_sucursal);
    			
    			this.idDireccion.setText(String.valueOf(sucursal.getId_direccion()));
    			this.nombre.setText(sucursal.getNombre());
    		}
		} catch (Exception e) {
			System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Limpiar(ActionEvent evt) { 
    	try {
    		this.idSucursal.setText("");
    		this.idDireccion.setText("");
    		this.nombre.setText("");
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Actualizar(ActionEvent evt) { 
    	try {
    		String nombre;
    		int id_direccion, id_sucursal;
    		id_sucursal = Integer.parseInt(this.idSucursal.getText());
    		nombre = this.nombre.getText();
    		id_direccion = Integer.parseInt(this.idDireccion.getText());
    		
        	if (id_direccion == 0 || nombre == null) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			id_direccion = Integer.parseInt(this.idDireccion.getText());
    			nombre = this.nombre.getText();
    			
    			Sucursal sucursal = new Sucursal(con, 5, id_sucursal, id_direccion, nombre);
    		}
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Eliminar(ActionEvent evt) { 
    	try {
    		int id_sucursal;
    		id_sucursal = Integer.parseInt(this.idSucursal.getText());
    		
        	if (id_sucursal == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Sucursal sucursal = new Sucursal(con, 4, id_sucursal);
    			
        		this.idSucursal.setText("");
        		this.idDireccion.setText("");
        		this.nombre.setText("");
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

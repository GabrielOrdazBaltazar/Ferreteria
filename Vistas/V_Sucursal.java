package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V_Sucursal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idDireccion;
	private JTextField nombre;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			V_Sucursal dialog = new V_Sucursal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public V_Sucursal(Conexion con) {
		this.con = con;
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		
		setBounds(100, 100, 490, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelSusucrsal = new JPanel();
			contentPanel.add(panelSusucrsal);
			
			JLabel label_Sucursal = new JLabel("Ingrese Sucursal");
			label_Sucursal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblIdDireccion = new JLabel("ID Direccion:");
			lblIdDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			idDireccion = new JTextField();
			idDireccion.setColumns(10);
			
			JLabel label_nombre = new JLabel("Nombre:");
			label_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			nombre = new JTextField();
			nombre.setColumns(10);
			
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
			
			GroupLayout gl_panelSusucrsal = new GroupLayout(panelSusucrsal);
			gl_panelSusucrsal.setHorizontalGroup(
				gl_panelSusucrsal.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 443, Short.MAX_VALUE)
					.addGroup(gl_panelSusucrsal.createSequentialGroup()
						.addGap(133)
						.addComponent(label_Sucursal)
						.addContainerGap(163, Short.MAX_VALUE))
					.addGroup(gl_panelSusucrsal.createSequentialGroup()
						.addGap(23)
						.addGroup(gl_panelSusucrsal.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelSusucrsal.createSequentialGroup()
								.addComponent(lblIdDireccion)
								.addGap(18)
								.addComponent(idDireccion, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelSusucrsal.createSequentialGroup()
								.addComponent(label_nombre, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_panelSusucrsal.createParallelGroup(Alignment.LEADING)
							.addComponent(btnGuardar)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGap(53))
					.addGroup(gl_panelSusucrsal.createSequentialGroup()
						.addContainerGap(303, Short.MAX_VALUE)
						.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGap(29))
			);
			gl_panelSusucrsal.setVerticalGroup(
				gl_panelSusucrsal.createParallelGroup(Alignment.LEADING)
					.addGap(0, 187, Short.MAX_VALUE)
					.addGroup(gl_panelSusucrsal.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_Sucursal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelSusucrsal.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIdDireccion)
							.addComponent(idDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGuardar))
						.addGap(18)
						.addGroup(gl_panelSusucrsal.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_nombre)
							.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar))
						.addGap(18)
						.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE))
			);
			panelSusucrsal.setLayout(gl_panelSusucrsal);
		}
	}
	
	private void Guardar(ActionEvent evt) { //java.awt.event.
    	try {
    		String nombre;
    		int id_direccion;
    		nombre = this.nombre.getText();
    		id_direccion = Integer.parseInt(this.idDireccion.getText());
    		
        	if (id_direccion == 0 || nombre == null) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			Sucursal almacen = new Sucursal(con, 1, id_direccion, nombre);
    			this.idDireccion.setText("");
    			this.nombre.setText("");
    		}
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Buscar(ActionEvent evt) {
		try {
			ModSucursal editSucursal = new ModSucursal(con);
			editSucursal.setLocation(450, 500);
	    	editSucursal.setVisible(true);
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

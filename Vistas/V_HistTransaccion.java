package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Almacen;
import Clases.Conexion;
import Clases.HistTransaccion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V_HistTransaccion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField precioUnitario;
	private JTextField fecha;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			V_HistTransaccion dialog = new V_HistTransaccion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public V_HistTransaccion(Conexion con) {
		this.con = con;
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		
		setBounds(100, 100, 484, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelHistTransaccion = new JPanel();
			contentPanel.add(panelHistTransaccion);
			
			JLabel label_histTransaccion = new JLabel("Ingrese Transaccion");
			label_histTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel label_fecha = new JLabel("Fecha:");
			label_fecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			fecha = new JTextField();
			fecha.setColumns(10);
			
			JLabel label_precioUnitario = new JLabel("Precio unitario:");
			label_precioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			precioUnitario = new JTextField();
			precioUnitario.setColumns(10);
			
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
			
			GroupLayout gl_panelHistTransaccion = new GroupLayout(panelHistTransaccion);
			gl_panelHistTransaccion.setHorizontalGroup(
				gl_panelHistTransaccion.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 449, Short.MAX_VALUE)
					.addGroup(gl_panelHistTransaccion.createSequentialGroup()
						.addContainerGap(16, Short.MAX_VALUE)
						.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(label_fecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_precioUnitario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panelHistTransaccion.createSequentialGroup()
								.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelHistTransaccion.createSequentialGroup()
										.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.LEADING)
											.addComponent(precioUnitario, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
											.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(btnBuscar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnGuardar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addComponent(label_histTransaccion))
								.addGap(43))
							.addGroup(gl_panelHistTransaccion.createSequentialGroup()
								.addComponent(btnRegistros)
								.addGap(24))))
			);
			gl_panelHistTransaccion.setVerticalGroup(
				gl_panelHistTransaccion.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 186, Short.MAX_VALUE)
					.addGroup(gl_panelHistTransaccion.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addComponent(label_histTransaccion, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_fecha)
							.addComponent(fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGuardar))
						.addGap(18)
						.addGroup(gl_panelHistTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_precioUnitario)
							.addComponent(precioUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar))
						.addGap(12)
						.addComponent(btnRegistros)
						.addContainerGap())
			);
			panelHistTransaccion.setLayout(gl_panelHistTransaccion);
		}
	}
	
	private void Guardar(ActionEvent evt) { //java.awt.event.
    	try {
    		String fecha;
    		float precio_unitario;
    		fecha = this.fecha.getText();
    		precio_unitario = Float.valueOf(this.precioUnitario.getText());
    		
        	if (precio_unitario == 0 || fecha == null) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			HistTransaccion histTransaccion = new HistTransaccion(con, 1, fecha, precio_unitario);
    			this.fecha.setText("");
    			this.precioUnitario.setText("");
    		}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null," Error: "+e.getMessage());
		}
    }
	
	private void Buscar(ActionEvent evt) {
		try {
			ModHistTransaccion ediHistTransaccion = new ModHistTransaccion(con);
	    	ediHistTransaccion.setLocation(450, 500);
	    	ediHistTransaccion.setVisible(true);
	    	this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null," Error: "+e.getMessage());
		}
    }
	
	private void VerTabla(ActionEvent evt) {
    	try {
    		
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null," Error: "+e.getMessage());
		}
    }
}

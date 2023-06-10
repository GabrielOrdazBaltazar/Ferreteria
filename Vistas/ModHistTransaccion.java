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
import Clases.HistTransaccion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModHistTransaccion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fecha;
	private JTextField idTrancaccion;
	private JTextField precioUnitario;
	private Conexion con;

	/*public static void main(String[] args) {
		try {
			ModHistTransaccion dialog = new ModHistTransaccion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public ModHistTransaccion(Conexion con) {
		this.con = con;	
		Componentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.pack();
	}

	public void Componentes() {
		
		setBounds(100, 100, 469, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panelTransaccion = new JPanel();
			contentPanel.add(panelTransaccion);
			
			JLabel label_idTransaccion = new JLabel("ID Transaccion:");
			label_idTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_fecha = new JLabel("Fecha:");
			label_fecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel label_precioUnitario = new JLabel("Precio Unitario:");
			label_precioUnitario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			fecha = new JTextField();
			fecha.setColumns(10);
			idTrancaccion = new JTextField();
			idTrancaccion.setColumns(10);
			precioUnitario = new JTextField();
			precioUnitario.setColumns(10);
			
			
			
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
			
			JButton btnActializar = new JButton("Actualizar");
			btnActializar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Actualizar(evt);
				}
			});
			btnActializar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
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
			
			JLabel label_histTransaccion = new JLabel("Transaccion");
			label_histTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			GroupLayout gl_panelTransaccion = new GroupLayout(panelTransaccion);
			gl_panelTransaccion.setHorizontalGroup(
				gl_panelTransaccion.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 434, Short.MAX_VALUE)
					.addGroup(gl_panelTransaccion.createSequentialGroup()
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelTransaccion.createSequentialGroup()
								.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label_idTransaccion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_fecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_precioUnitario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.LEADING)
									.addComponent(fecha, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
									.addComponent(idTrancaccion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
									.addComponent(precioUnitario, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
							.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.LEADING)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnActializar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(15, Short.MAX_VALUE))
					.addGroup(gl_panelTransaccion.createSequentialGroup()
						.addContainerGap(166, Short.MAX_VALUE)
						.addComponent(label_histTransaccion)
						.addGap(162))
			);
			gl_panelTransaccion.setVerticalGroup(
				gl_panelTransaccion.createParallelGroup(Alignment.LEADING)
					.addGap(0, 231, Short.MAX_VALUE)
					.addGroup(gl_panelTransaccion.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_histTransaccion)
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_idTransaccion)
							.addComponent(idTrancaccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_fecha)
							.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_precioUnitario)
							.addComponent(btnActializar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(precioUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelTransaccion.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRegistros, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(15, Short.MAX_VALUE))
			);
			panelTransaccion.setLayout(gl_panelTransaccion);
		}
	}
	
	private void Buscar(ActionEvent evt) {//java.awt.event.
		try {
			int id_histTransaccion;
    		id_histTransaccion = Integer.parseInt(idTrancaccion.getText());
    		
    		if(id_histTransaccion == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			HistTransaccion histTransaccion = new HistTransaccion(con, 2, id_histTransaccion);
    			
    			this.precioUnitario.setText(String.valueOf(histTransaccion.getPrecio_unitario()));
    			this.fecha.setText(histTransaccion.getFecha());
    		}
		} catch (Exception e) {
			System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Limpiar(ActionEvent evt) { 
    	try {
    		this.idTrancaccion.setText("");
    		this.fecha.setText("");
    		this.precioUnitario.setText("");
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Actualizar(ActionEvent evt) { 
    	try {
    		int id_histTransaccion;
    		String fecha;
    		float precio_unitario;
    		id_histTransaccion = Integer.parseInt(this.idTrancaccion.getText());
    		
        	if (id_histTransaccion == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			fecha = this.fecha.getText();
        		precio_unitario = Float.valueOf(this.precioUnitario.getText());
    			
        		HistTransaccion histTransaccion = new HistTransaccion(con, 4, id_histTransaccion, fecha, precio_unitario);
    		}
    	} catch (Exception e) {
    		System.out.println(" Error: "+e.getMessage());
		}
    }
	
	private void Eliminar(ActionEvent evt) { 
    	try {
    		int id_histTransaccion;
    		id_histTransaccion = Integer.parseInt(this.idTrancaccion.getText());
    		
        	if (id_histTransaccion == 0) {
    			JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
    		} else {
    			HistTransaccion histTransaccion = new HistTransaccion(con, 3, id_histTransaccion);
    			
    			this.idTrancaccion.setText("");
        		this.fecha.setText("");
        		this.precioUnitario.setText("");
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

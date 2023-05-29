package Ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import paquete1.Conexion;
import paquete1.Direccion;
import paquete1.Proveedor;

public class vDireccion extends JFrame implements ActionListener{
	public JPanel principal, agrupar;
	public JTextField recuadroNom,recuadroAP,recuadroAM,recuadroCorreo,recuadroRFC,recuadroEmp,recuadroGiro,recuadroEst,recuadroMun,recuadroNo;
	public JSpinner recuadroId_p,recuadroId_d,recuadroNum, recuadroCod;
	public JLabel texto;
	public JButton btn;
	public GridBagConstraints c;
	private Conexion con;
	
	
	
	public vDireccion(Conexion con) {
		this.con = con;
		Ingresar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}



	public void Ingresar() {
		principal = new JPanel(new BorderLayout());
		agrupar = new JPanel(new GridBagLayout());
		
		texto = new JLabel("Proveedor");
		texto.setHorizontalAlignment(JLabel.CENTER);
		principal.add(texto, BorderLayout.NORTH);
		
		//id_persona, id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc, id_proveedor, empresa, giro
		/*
		pstmt.setInt(1, getId_persona());
		pstmt.setInt(2, getId_persona());
	 	pstmt.setString(3, getNombre());
		pstmt.setString(4, getApellido_paterno());
		pstmt.setString(5, getApellido_materno());
		pstmt.setInt(6, getNumero_Telefono());
		pstmt.setString(7, getCorreo());
		pstmt.setString(8, getRfc());
		estado = recuadroEst.getText();
		municipio = recuadroMun.getText();
		no_ext = recuadroNo.getText();
		id_dir = (Integer)recuadroId.getValue();
		cod_post = (Integer)recuadroCod.getValue();
		pstmt.setInt(9, getId_proveedor());
		pstmt.setString(10, getEmpresa());
		pstmt.setString(11, getGiro());
		*/
		texto = new JLabel("Id proveedor: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Nombre: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Apellido paterno: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Apellido materno: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Numero de telefono: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Correo: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("RFC: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 6;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Id direccion: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 7;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Estado: ");

		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 8;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Municipio: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 9;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Codigo postal: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 10;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Numero exterior: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 11;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Empresa: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 12;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		texto = new JLabel("Giro: ");
		c= new GridBagConstraints();
		c.anchor= GridBagConstraints.LINE_END;
		c.gridx = 0;
		c.gridy = 13;
		c.ipady = 15;
		c.ipadx = 15;
		agrupar.add(texto, c);
		
		
		
		/*
		recuadroNom,recuadroAP,recuadroAM,recuadroCorreo,recuadroRFC,recuadroEmp,recuadroGiro,recuadroEst,recuadroMun,recuadroNo;
		recuadroId_p,recuadroId_d,recuadroNum, recuadroCod;
		 */
		
		recuadroId_p =  new JSpinner();
		recuadroId_p.setMinimumSize(new Dimension(60, 30));
		recuadroId_p.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 15;
		agrupar.add(recuadroId_p, c);
		
		
		recuadroNom =  new JTextField();
		recuadroNom.setMinimumSize(new Dimension(60, 30));
		recuadroNom.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 15;
		agrupar.add(recuadroNom, c);
		
		recuadroAP =  new JTextField();
		recuadroAP.setMinimumSize(new Dimension(60, 30));
		recuadroAP.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 15;
		agrupar.add(recuadroAP, c);
		
		recuadroAM =  new JTextField();
		recuadroAM.setMinimumSize(new Dimension(60, 30));
		recuadroAM.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 3;
		c.ipadx = 15;
		agrupar.add(recuadroAM, c);
		
		recuadroNum =  new JSpinner();
		recuadroNum.setMinimumSize(new Dimension(60, 30));
		recuadroNum.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 4;
		c.ipadx = 15;
		agrupar.add(recuadroNum, c);
		
		recuadroCorreo =  new JTextField();
		recuadroCorreo.setMinimumSize(new Dimension(60, 30));
		recuadroCorreo.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 5;
		c.ipadx = 15;
		agrupar.add(recuadroCorreo, c);
		
		recuadroRFC =  new JTextField();
		recuadroRFC.setMinimumSize(new Dimension(60, 30));
		recuadroRFC.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 6;
		c.ipadx = 15;
		agrupar.add(recuadroRFC, c);
		
		recuadroId_d =new JSpinner();
		recuadroId_d.setMinimumSize(new Dimension(60, 30));
		recuadroId_d.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 7;
		c.ipadx = 15;
		agrupar.add(recuadroId_d, c);
		
		recuadroEst =  new JTextField();
		recuadroEst.setMinimumSize(new Dimension(60, 30));
		recuadroEst.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 8;
		c.ipadx = 15;
		agrupar.add(recuadroEst, c);
		
		recuadroMun =  new JTextField();
		recuadroMun.setMinimumSize(new Dimension(60, 30));
		recuadroMun.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 9;
		c.ipadx = 15;
		agrupar.add(recuadroMun, c);
		
		recuadroCod =  new JSpinner();
		recuadroCod.setMinimumSize(new Dimension(60, 30));
		recuadroCod.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 10;
		c.ipadx = 15;
		agrupar.add(recuadroCod, c);
		
		recuadroNo =  new JTextField();
		recuadroNo.setMinimumSize(new Dimension(60, 30));
		recuadroNo.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 11;
		c.ipadx = 15;
		agrupar.add(recuadroNo, c);
		
		recuadroEmp =  new JTextField();
		recuadroEmp.setMinimumSize(new Dimension(60, 30));
		recuadroEmp.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 12;
		c.ipadx = 15;
		agrupar.add(recuadroEmp, c);
		
		recuadroGiro =  new JTextField();
		recuadroGiro.setMinimumSize(new Dimension(60, 30));
		recuadroGiro.setPreferredSize(new Dimension(350,30));
		c= new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 13;
		c.ipadx = 15;
		agrupar.add(recuadroGiro, c);
		
		
		
		
		btn = new JButton("Buscar");
		
		btn.setPreferredSize(new Dimension(100, 30));
		c= new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.ipadx = 15;
		agrupar.add(btn);
		principal.add(agrupar, BorderLayout.CENTER);
		
		agrupar = new JPanel(new FlowLayout());
		
		btn = new JButton("Ingresar");
		btn.setPreferredSize(new Dimension(150, 30));
		agrupar.add(btn);
		btn.setActionCommand("ins");
		btn.addActionListener(this);

		
		btn = new JButton("Borrar");
		btn.setPreferredSize(new Dimension(150, 30));
		agrupar.add(btn);
		btn.setActionCommand("del");
		btn.addActionListener(this);
		
		btn = new JButton("Actualizar");
		btn.setPreferredSize(new Dimension(150, 30));
		agrupar.add(btn);
		btn.setActionCommand("upd");
		btn.addActionListener(this);
		principal.add(agrupar, BorderLayout.SOUTH);
		
		this.getContentPane().add(principal);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String comando;

		int act;
		comando = e.getActionCommand();
		

		try {
			switch (comando) {
			case "ins":
				//id_persona, id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc, id_proveedor, empresa, giro
				String nombre, apellidoP, apellidoM, correo, rfc, estado, municipio, no_ext, empresa, giro;
				int id_pro, id_dir, num,cod_post;
				
				nombre = recuadroNom.getText();
				apellidoP = recuadroAP.getText();
				apellidoM = recuadroAM.getText();
				correo = recuadroCorreo.getText();
				rfc = recuadroRFC.getText();
				estado = recuadroEst.getText();
				municipio = recuadroMun.getText();
				no_ext = recuadroNo.getText();
				empresa = recuadroEmp.getText();
				giro = recuadroGiro.getText();
				
				id_pro = (Integer)recuadroId_p.getValue();
				id_dir = (Integer)recuadroId_d.getValue();
				num = (Integer)recuadroNum.getValue();
				cod_post = (Integer)recuadroCod.getValue();
				
				if (nombre == null|| apellidoP == null|| apellidoM == null||correo == null||rfc==null||estado==null||municipio==null||no_ext==null||id_pro==0||id_dir==0||num==0||cod_post==0) {
					JOptionPane.showMessageDialog(null, "No se han ingresado todos los valores");
				} else {
					Direccion dir = new Direccion(estado, municipio,cod_post,no_ext);
					dir.setCon(con);
					dir.insertDireccion();
					
					Proveedor prov =  new Proveedor(id_pro, empresa, giro, id_pro, dir, nombre, apellidoP, apellidoM, cod_post, correo, rfc);
					prov.setCon(con);
					prov.insertProveedor();
					
				}

				break;

			default:
				System.out.println("Error");
				break;
			}
		} catch (Exception e2) {
			System.out.println(" Error: "+e2.getMessage());
		}
		
	}
}

package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Conexion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class V_Ferreteria extends JFrame {

	private JPanel panelFerreteria;
	Conexion conectar = new Conexion("5432", "postgres", "postgres", "12345", "ferreteria");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scanner S = new Scanner(System.in);
					V_Ferreteria frame = new V_Ferreteria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public static void main(String[] args) {
    	Scanner S = new Scanner(System.in);
    	Conexion conectar = new Conexion("5432", "postgres", "bdferreteria", "postgres", "1234");
		conectar.Conec();
		V_Ferreteria frame = new V_Ferreteria(conectar);
	}*/

	public V_Ferreteria() {
		setTitle("Ferreteria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu menuTablas = new JMenu("Tablas");
		barraMenu.add(menuTablas);
		
		JMenuItem tablaAlmacen = new JMenuItem("Almacen");
		tablaAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				V_Almacen(evt);
			}
		});
		menuTablas.add(tablaAlmacen);
		
		JMenuItem tablaSucursal = new JMenuItem("Sucursal");
		tablaSucursal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				V_Sucursal(evt);
			}
		});
		menuTablas.add(tablaSucursal);
		
		JMenuItem tablaHistTransaccion = new JMenuItem("Historial Transaccion");
		tablaHistTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				V_HistTransaccion(evt);
			}
		});
		menuTablas.add(tablaHistTransaccion);
		
		panelFerreteria = new JPanel();
		panelFerreteria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelFerreteria);
		
		GroupLayout gl_panelFerreteria = new GroupLayout(panelFerreteria);
		gl_panelFerreteria.setHorizontalGroup(
			gl_panelFerreteria.createParallelGroup(Alignment.LEADING)
				.addGap(0, 624, Short.MAX_VALUE)
		);
		gl_panelFerreteria.setVerticalGroup(
			gl_panelFerreteria.createParallelGroup(Alignment.LEADING)
				.addGap(0, 325, Short.MAX_VALUE)
		);
		panelFerreteria.setLayout(gl_panelFerreteria);
	}
	
    private void V_Almacen(ActionEvent evt) { //java.awt.event.
    	conectar.Conec();
    	V_Almacen ventanaAlmacen = new V_Almacen(conectar);
    	ventanaAlmacen.setLocation(450, 500);
        ventanaAlmacen.setVisible(true);
    }

    private void V_Sucursal(ActionEvent evt) {
    	conectar.Conec();
    	V_Sucursal ventanaSucursal = new V_Sucursal(conectar);
    	ventanaSucursal.setLocation(450, 500);
    	ventanaSucursal.setVisible(true);
    }

    private void V_HistTransaccion(ActionEvent evt) {
    	conectar.Conec();
    	V_HistTransaccion ventanaHistTransaccion = new V_HistTransaccion(conectar);
    	ventanaHistTransaccion.setLocation(450, 500);
    	ventanaHistTransaccion.setVisible(true);
    }
}

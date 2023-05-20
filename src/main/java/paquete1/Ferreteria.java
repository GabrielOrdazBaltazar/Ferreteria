package paquete1;

import java.util.Scanner;

public class Ferreteria {    
    public static void main(String[] args) {
    	
Scanner S = new Scanner(System.in);
		
		String Pue, Nom, Esq, Usu, Con;

		System.out.println("Ingrese el puerto de la base de datos: ");
		Pue = S.next();
		
		System.out.println("Ingrese el nombre de la base de datos: ");
		Nom = S.next();
		
		System.out.println("Ingrese el esquema de la base de datos: ");
		Esq = S.next();
		
		System.out.println("Ingrese el usuario con el que entrara a la base de datos: ");
		Usu = S.next();
		
		System.out.println("Ingrese la contraseña de la base de datos: ");
		Con = S.next();
		
		Conexion conectar = new Conexion(Pue, Nom, Esq, Usu, Con);
		conectar.Conec();
		
		//Direccion dir = new Direccion(1,"Estado de Mexico", "Toluca",1423,"142");
		Direccion dir = new Direccion();
		dir.setCon(conectar);
		
		/*
		dir.insertDireccion();
		dir.queryDireccion();
		dir.dropDireccion(0);
		dir.updateDireccion(0, "", 0);
		*/
		
		//Proveedor pro = new Proveedor(1, "DLD", "comercial", 1, dir, "Raul","Marquez", "", 714523604, "asdfgh@gmail.com", "asd4ds9d8s");
		Proveedor pro = new Proveedor();
		pro.setCon(conectar);
		
		/*
		pro.insertProveedor();
		pro.queryProveedor();
		pro.dropProveedor(0);
		pro.updateProveedor(0, "", 0);
		*/
    }
}

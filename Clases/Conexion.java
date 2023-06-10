package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection BD = null;
	private String Puerto, Nombre, Usususrio, Contrasena, Esquema, Url;
	
	public Conexion(String puerto, String nombre, String usuario, String contrasena, String esquema) {
		super();
		this.Puerto = puerto;
		this.Nombre = nombre;
		this.Usususrio = usuario;
		this.Contrasena = contrasena;
		this.Esquema = esquema;
	}
	
	public static Connection getBD() {
		return BD;
	}

	public static void setBD(Connection conex) {
		conex = BD;
	}

	public String getPuerto() {
		return Puerto;
	}

	public void setPuerto(String puerto) {
		this.Puerto = puerto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getEsquema() {
		return Esquema;
	}

	public void setEsquema(String esquema) {
		this.Esquema = esquema;
	}

	public String getUsuario() {
		return Usususrio;
	}

	public void setUsuario(String usuario) {
		this.Usususrio = usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		this.Contrasena = contrasena;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		this.Url = url;
	}

	public void Conec() {
		
		Url = "jdbc:postgresql://localhost:"+Puerto+"/"+Nombre+"?currentSchema="+Esquema;
		try {
			BD = DriverManager.getConnection(Url, Usususrio, Contrasena);
			System.out.println("Se entro a la base de datos de forma exitosa!!");
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}
}

package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection BD = null;
	private String Pue, Nom, Esq, Usu, Con, Url;
	public Conexion(String pue, String nom, String esq, String usu, String con) {
		super();
		Pue = pue;
		Nom = nom;
		Esq = esq;
		Usu = usu;
		Con = con;
	}

	public static Connection getBD() {
		return BD;
	}

	public static void setBD(Connection bD) {
		BD = bD;
	}

	public String getPue() {
		return Pue;
	}

	public void setPue(String pue) {
		Pue = pue;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getEsq() {
		return Esq;
	}

	public void setEsq(String esq) {
		Esq = esq;
	}

	public String getUsu() {
		return Usu;
	}

	public void setUsu(String usu) {
		Usu = usu;
	}

	public String getCon() {
		return Con;
	}

	public void setCon(String con) {
		Con = con;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void Conec () {

		Url = "jdbc:postgresql://localhost:"+Pue+"/"+Nom+"?currentSchema="+Esq;
		try {
			BD = DriverManager.getConnection(Url, Usu, Con);
			System.out.println("Entro a la base de datos");
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}


}
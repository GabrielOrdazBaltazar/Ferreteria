package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sucursal {

	private int id_sucursal;
	private Direccion id_direccion;
	private String nombre;

	public Sucursal(int id_sucursal, Direccion id_direccion, Sring nombre) {
		this.id_sucursal = id_sucursal;
		this.id_direccion = id_direccion;
		this.nombre = nombre;
	}

	public Sucursal() {
		super();
	}

	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public int getId_sucursal() {
		return id_sucursal;
	}

	public void setId_direccion(Direccion id_direccion) {
		this.id_direccion = id_direccion;
	}

	public Direccion getId_direccion() {
		return id_direccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setConexion(Conexion con) {
		this.cononexion = con;
	}
	    
	public Conexion getConexion() {
		return conexion;
	}

	public Connection connect() throws SQLException {
	return DriverManager.getConnection(getConexion().getUrl(), 
					   getConexion().getUsuarion(), 
					   getConexion().getContrasena());
	}

	public void insertSucursal (){
		String insertar = "INSERT INTO sucursal(id_sucursal, id_direccion, nombre)"+"VALUES(?,?,?,?,?);";
		try(Connection conexion_BD = connect();
		    PreparedStatement pstmt = conexion_BD.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
			pstmt.setInt(1, getId_sucursal());
			pstmt.setInt(2, getId_direccion());
			pstmt.setString(3, getNombre());
			System.out.println(pstmt);
			pstmt.executeUpdate();
			conexion_BD.close();
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}
	    
	public void querySucursal (){
		try(Connection conexion_BD = connect();
		    Statement query = conexion_BD.createStatement();){
		    ResultSet resultado = query.executeQuery("SELECT * FROM sucursal;");
			if (resultado == null){
				if(resultado != null) resultado.close();
				if(query != null) query.close();
				conexion_BD.close();
			} else {
				while (resultado.next()){	
					System.out.println("|\t"+resultado.getInt("id_sucursal")
							+"\t|\t"+resultado.getInt("id_direccion")
							+"\t|\t"+resultado.getString("nombre")
							+"\t|");
				}
				resultado.close();
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}
	    
	public void dropSucursal (int id_sucursal){
		String eliminar = "DELETE FROM sucursal WHERE id_sucursal = ?";
		try(Connection conexion_BD = connect();
		    PreparedStatement pstmt = conexion_BD.prepareStatement(eliminar)){
			pstmt.setInt(1, id_sucursal);
			System.out.println(pstmt);
			pstmt.executeUpdate();
			conexion_BD.close();
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}
	    
	public void updateAlmacen (int id_sucursal, String nuevo,int valor){
		String alctualizar = null;
		switch (valor) {

		case 1: alctualizar = "UPDATE sucursal SET id_direccion=? WHERE id_sucursal=?";
			try(Connection conexion_BD = connect();
			    PreparedStatement pstmt = conexion_BD.prepareStatement(alctualizar)){
				pstmt.setString(1, nuevo);
				pstmt.setInt(2, id_sucursal);
				System.out.println(pstmt);
				pstmt.executeUpdate();
				if(pstmt.executeUpdate() > 0){
					System.out.println("Los datos han sido modificados con éxito");
				}else{
					System.out.println("No se ha podido realizar la actualización de los datos\n");
				}
				conexion_BD.close();
			} catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
			break;

		case 2: alctualizar = "UPDATE sucursal SET nombre WHERE id_sucursal=?";
			try(Connection conn = connect();
			    PreparedStatement pstmt = conn.prepareStatement(alctualizar)){
				pstmt.setString(1, nuevo);
				pstmt.setInt(2, id_sucursal);
				System.out.println(pstmt);
				pstmt.executeUpdate();
				if(pstmt.executeUpdate() > 0){
					System.out.println("Los datos han sido modificados con éxito");
				}else{
					System.out.println("No se ha podido realizar la actualización de los datos\n");
				}
				conn.close();
			} catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
			break;

		default:
			System.out.println("No se puede cambiar ese dato");
			break;
		}
	}
}

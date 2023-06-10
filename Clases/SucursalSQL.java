package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SucursalSQL {
	
	protected int id_sucursal;
	protected Sucursal sucursal;
	protected Conexion conexion;
	
	public SucursalSQL() {
		super();
	}
	
	public SucursalSQL(Sucursal sucursal) {
		super();
		this.sucursal = sucursal;
	}
	
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	 
	public int getId_sucursal() {
		return id_sucursal;
	}
	
	public void setConexion(Conexion conex) {
		this.conexion = conex;
	}
    
    public Conexion getConexion() {
		return conexion;
	}

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(getConexion().getUrl(), 
        									getConexion().getUsuario(), 
        									getConexion().getContrasena());
    }
    
    public void obtenerID() {
 	   int ID = 0;
 	   String obtener_id = "SELECT MAX(id_sucursal) FROM sucursal;";
 		
 	   ResultSet rs = null;
 		
 	   try{
 			Connection conn = connect();
 			Statement query = conn.createStatement();
 			query.executeQuery(obtener_id);
 			
 			rs = query.getResultSet();
 			while (rs.next()){	
 				ID = rs.getInt(1);
 			}
 			
 			System.out.println(ID);
 			sucursal.setId_sucursal(ID+1);
 			
 		} catch (SQLException e) {
 			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
 		}
    }
    
    public void obtener_IDSucursal (int id_direccion){
		
		String buscar = "SELECT id_sucursal FROM direccion WHERE id_direccion = ?;";
		ResultSet rs = null;
		
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(buscar)){
				
			pstmt.setInt(1, id_sucursal);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				setId_sucursal((rs.getInt("id_sucursal"))); ;
			} else {
				if(rs != null) rs.close();
				conn.close();
			}
			
			System.out.println(pstmt);  
			conn.close();
				 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void buscarSucursal (int id_sucursal){
		
		String buscar = "SELECT * FROM sucursal WHERE id_sucursal = ?;";
		ResultSet rs = null;
		
		try(Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(buscar)){
				
			pstmt.setInt(1, id_sucursal);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sucursal.setId_direccion(rs.getInt("id_direccion"));
				sucursal.setNombre(rs.getString("nombre"));
			} else {
				if(rs != null) rs.close();
				conn.close();
			}
			
			System.out.println(pstmt);  
			conn.close();
				 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void insertSucursal (int id_direccion, String nombre){
		String insertar = "INSERT INTO sucursal(id_direccion, nombre) "+"VALUES(?,?);";
		
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
			
				pstmt.setInt(1, id_direccion);
				pstmt.setString(2, nombre);
				
				System.out.println(pstmt);
				obtenerID();
				
				pstmt.executeUpdate();
				conexion_BD.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void consultarSucursal (){
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
    
    public void updateSucursal (int id_sucursal, int id_direccion, String nombre){
		String alctualizar = null;
		alctualizar = "UPDATE sucursal SET id_direccion=?, nombre=? WHERE id_sucursal=?";
		
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(alctualizar)){
			
				pstmt.setInt(1, id_direccion);
				pstmt.setString(2, nombre);
				pstmt.setInt(3, id_sucursal);
				
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
    }
}

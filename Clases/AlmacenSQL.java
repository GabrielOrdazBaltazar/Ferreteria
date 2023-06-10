package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlmacenSQL {
	
	protected int id_almacen;
	protected Almacen almacen;
	protected Conexion conex;
	
	public AlmacenSQL() {
		super();
	}
	
	public AlmacenSQL(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void setId_almacen(int id_almacen) {
		this.id_almacen = id_almacen;
	}
	 
	public int getId_almacen() {
		return id_almacen;
	}
    
	public void setConexion(Conexion conex) {
		this.conex = conex;
	}
	
	public Conexion getConexion() {
		return conex;
	}

   public Connection connect() throws SQLException {
       return DriverManager.getConnection(getConexion().getUrl(), 
       									  getConexion().getUsuario(), 
       									  getConexion().getContrasena());
   }
   
   public void obtenerID() {
	   int ID = 0;
	   String obtener_id = "SELECT MAX(id_almacen) FROM almacen;";
		
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
			almacen.setId_almacen(ID+1);
			
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
   	}
   
   	public void obtener_IDAlmacen (int id_sucursal){
		
		String buscar = "SELECT id_almacen FROM sucursal WHERE id_sucursal = ?;";
		ResultSet rs = null;
		
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(buscar)){
				
			pstmt.setInt(1, id_sucursal);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				setId_almacen((rs.getInt("id_almacen"))); ;
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
   
   public void buscarAlmacen (int id_almacen){
		
		String buscar = "SELECT * FROM almacen WHERE id_almacen = ?;";
		ResultSet rs = null;
		
		try(Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(buscar)){
				
			pstmt.setInt(1, id_almacen);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				almacen.setId_sucursal(rs.getInt("id_sucursal"));
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
   
   public void insertAlmacen(int id_sucursal){
		String insertar = "INSERT INTO almacen(id_sucursal) "+"VALUES(?);";
		
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
				
				pstmt.setInt(1, id_sucursal);
				
				System.out.println(pstmt);
				obtenerID();
				
				pstmt.executeUpdate();
				conexion_BD.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void consultarAlmacen (){
		try(Connection conexion_BD = connect();
			Statement query = conexion_BD.createStatement();){
			ResultSet resultado = query.executeQuery("SELECT * FROM almacen;");
			
				if (resultado == null){
					if(resultado != null) resultado.close();
					if(query != null) query.close();
					conexion_BD.close();
				} else {
					while (resultado.next()){	
						System.out.println("|\t"+resultado.getInt("id_almacen")
										+"\t|\t"+resultado.getInt("id_sucursal")
										+"\t|");
					}
					resultado.close();
				}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void dropAlmacen (int id_almacen){
		String eliminar = "DELETE FROM almacen WHERE id_almacen = ?";
		
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(eliminar)){
			
				pstmt.setInt(1, id_almacen);
				
				System.out.println(pstmt);
				
				pstmt.executeUpdate();
				conexion_BD.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void updateAlmacen (int id_almacen, int id_sucursal){ 
		String alctualizar = null;
		alctualizar = "UPDATE almacen SET id_sucursal=? WHERE id_almacen=?";
			
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(alctualizar)){
				
			pstmt.setInt(1, id_sucursal);
			pstmt.setInt(2, id_almacen);
			
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

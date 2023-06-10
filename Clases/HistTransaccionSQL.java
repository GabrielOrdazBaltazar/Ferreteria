package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistTransaccionSQL {
	
	protected int id_histTransaccion;
	protected HistTransaccion histTransaccion;
	protected Conexion conexion;

	public HistTransaccionSQL() {
		super();
	}
	
	public HistTransaccionSQL(HistTransaccion histTransaccion){
		super();
		this.histTransaccion = histTransaccion;
	}
    
    public void setId_histTransaccion(int id_histTransaccion) {
    	this.id_histTransaccion = id_histTransaccion;
    }
    
    public int getId_histTransaccion() {
    	return id_histTransaccion;
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
    	String obtener_id = "SELECT MAX(id_histTransaccion FROM histTransaccion;";
    	
    	ResultSet rs = null;
    	
    	try {
    		Connection conn = connect();
    		Statement query = conn.createStatement();
    		query.executeQuery(obtener_id);
    		
    		rs = query.getResultSet();
    		while(rs.next()) {
    			ID = rs.getInt(1);
    		}
    		System.out.println(ID);
    		histTransaccion.setId_histTransaccion(ID+1);
    		
    	}catch(SQLException e) {
    		System.out.println("No se pudo conectar con la base de datos. Error " + e.getMessage());
    	}
    }
    
    public void buscarHistTransaccion(int id_histTransaccion) {
    	
    	String buscar = "SELECT * FROM histTransaccion WHERE id_histTransaccion = ?;";
    	ResultSet rs = null;
    	
    	try(Connection conn = connect();
    		PreparedStatement pstmt = conn.prepareStatement(buscar)){
    		
    		pstmt.setInt(1, id_histTransaccion);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			histTransaccion.setFecha(rs.getString("fecha"));
    			histTransaccion.setPrecio_unitario(rs.getFloat("precio_unitario"));
    		}else {
    			if(rs != null) rs.close();
    			conn.close();
    		}
    		
    		System.out.println(pstmt);
    		conn.close();
    		
    	}catch(SQLException e){
    		System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
    	}
    }
    
    public void insertHistTransaccion (String fecha, float precio_unitario){
		String insertar = "INSERT INTO histTransaccion(fecha, precio_unitario) "+"VALUES(?,?);";
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
			
				pstmt.setDate(1, java.sql.Date.valueOf(fecha));
				pstmt.setFloat(2, precio_unitario);
				
				System.out.println(pstmt);
				obtenerID();
				
				pstmt.executeUpdate();
				conexion_BD.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void consultarHistTransaccion (){
		try(Connection conexion_BD = connect();
			Statement query = conexion_BD.createStatement();){
			ResultSet resultado = query.executeQuery("SELECT * FROM histTransaccion;");
			
				if (resultado == null){
					if(resultado != null) resultado.close();
					if(query != null) query.close();
					conexion_BD.close();
				} else {
					while (resultado.next()){	
						System.out.println("|\t"+resultado.getInt("id_histTransaccion")
										+"\t|\t"+resultado.getString("fecha")
										+"\t|\t"+resultado.getFloat("precio_unitario")
										+"\t|");
					}
					resultado.close();
				}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void dropHistTransaccion (int id_histTransaccion){
		String eliminar = "DELETE FROM histTransaccion WHERE id_histTransaccion = ?";
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(eliminar)){
				
				pstmt.setInt(1, id_histTransaccion);
				
				System.out.println(pstmt);
				
				pstmt.executeUpdate();
				conexion_BD.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void updateHistTransaccion (int id_histTransaccion, String fecha, float precio_unitario){
		String alctualizar = null;
		alctualizar = "UPDATE histTransaccion SET fecha=?,precio_unitario=? WHERE id_histTransaccion=?";
		
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(alctualizar)){
			
				pstmt.setDate(1, java.sql.Date.valueOf(fecha));
				pstmt.setFloat(2, precio_unitario);
				pstmt.setInt(3, id_histTransaccion);
				
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

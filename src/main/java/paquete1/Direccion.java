package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Direccion {
    //Atrinbutos
    private int			id_direccion;
    private String     	estado;
    private String     	municipio;
    private int    	 	codigo_postal;
    private String  	no_exterior;
    private Conexion 	con;
    
    //Metodos
    public Direccion(String estado, String municipio, int codigo_postal, String no_exterior) {
        
        this.estado = estado;
        this.municipio = municipio;
        this.codigo_postal = codigo_postal;
        this.no_exterior = no_exterior;
    }
    
    public Direccion() {
		super();
	}

	public int getId_direccion() {
        return id_direccion;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public String getNo_exterior() {
        return no_exterior;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setNo_exterior(String no_exterior) {
        this.no_exterior = no_exterior;
    }
    
    public Conexion getCon() {
		return con;
	}

	public void setCon(Conexion con) {
		this.con = con;
	}
	
	public Connection connect() throws SQLException {
		
        return DriverManager.getConnection(getCon().getUrl(), getCon().getUsu(), getCon().getCon());
    }
	
	public void Obtener() {
		int ID = 0;
		String obtener_id = "SELECT MAX(id_direccion) FROM direccion;";
		
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
			setId_direccion(ID+1);
			
			} catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
	}
	
	public void insertDireccion (){
		String incertar = "INSERT INTO direccion(estado, municipio, codigo_postal, no_exterior) "
				+"VALUES(?,?,?,?);";
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(incertar, Statement.RETURN_GENERATED_KEYS)){

			 pstmt.setString(1, getEstado());
			 pstmt.setString(2, getMunicipio());
			 pstmt.setInt(3, getCodigo_postal());
			 pstmt.setString(4, getNo_exterior());
			 
			 System.out.println(pstmt);
			 Obtener();
			 pstmt.executeUpdate();
	         
			 conn.close();
			 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
	
	public void queryDireccion (){
		try (Connection conn = connect();
				Statement query = conn.createStatement();){
			ResultSet rs = query.executeQuery("SELECT * FROM direccion;");
			if (rs == null){
				if(rs != null) rs.close();
				if(query != null) query.close();
				conn.close();
			}
			else {
				while (rs.next()){	
					System.out.println("|\t"+rs.getInt("id_direccion")+"\t\t|\t"+rs.getString("estado")
					+"\t\t|\t"+rs.getString("municipio")	+"\t|\t"+rs.getInt("codigo_postal")  
					+"\t|\t"+rs.getString("no_exterior")	+"\t|");
				}
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
	
	public void dropDireccion (int id){
		String eliminar = "DELETE FROM direccion WHERE id_direccion = ?";
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(eliminar)){
			
			 pstmt.setInt(1, id);
			 
			 System.out.println(pstmt);
			 
			 pstmt.executeUpdate();
	         
			 conn.close();
			 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
	
	public void updateDireccion (int id, String nuevo,int valor){
		String alctualizar = null;
		switch (valor) {
		case 1:
			alctualizar = "UPDATE direccion SET estado=? WHERE id_direccion=?";
			
			try(
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(alctualizar)){
				
				pstmt.setString(1, nuevo);
				pstmt.setInt(2, id);
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
		case 2:
			alctualizar = "UPDATE direccion SET municipio=? WHERE id_direccion=?";
			
			try(
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(alctualizar)){
				
				pstmt.setString(1, nuevo);
				pstmt.setInt(2, id);
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
		case 3:
			alctualizar = "UPDATE direccion SET codigo_postal=? WHERE id_direccion=?";
			
			try(
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(alctualizar)){
				
				pstmt.setInt(1, Integer.parseInt(nuevo));
				pstmt.setInt(2, id);
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
		case 4:
			alctualizar = "UPDATE direccion SET no_exterior=? WHERE id_direccion=?";
			
			try(
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(alctualizar)){
				
				pstmt.setString(1, nuevo);
				pstmt.setInt(2, id);
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

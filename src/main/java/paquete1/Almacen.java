package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Almacen {

    private int      id_almacen;
    private Sucursal id_sucursal;
    private Conexion conexion;

    public Almacen(int id_almacen, Sucursal id_sucursal) {
        this.id_almacen  = id_almacen;
        this.id_sucursal = id_sucursal;
    }
    
    public Almacen() {
    	super();
    }
    
    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_almacen() {
        return id_almacen;
    }
    
    public void setId_sucursal(Sucursal id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Sucursal getId_sucursal() {
        return id_sucursal;
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
    
    public void insertAlmacen (){
		String insertar = "INSERT INTO almacen(id_almacen, id_sucursal)"+"VALUES(?,?,?,?,?);";
		try(Connection conexion_BD = connect();
			PreparedStatement pstmt = conexion_BD.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
				pstmt.setInt(1, getId_almacen());
				pstmt.setInt(2, getId_sucursal());
				System.out.println(pstmt);
				pstmt.executeUpdate();
				conexion_BD.close();
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
    
    public void queryAlmacen (){
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
										+"\t|\t"+resultado.getInt("id_sucursal")+"\t|");
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
    
    public void updateAlmacen (int id_almacen, String nuevo,int valor){
		String alctualizar = null;
		switch (valor) {
			
		case 1: alctualizar = "UPDATE almacen SET id_sucursal=? WHERE id_almacen=?";
			try(Connection conexion_BD = connect();
				PreparedStatement pstmt = conexion_BD.prepareStatement(alctualizar)){
					pstmt.setString(1, nuevo);
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
			break;

		default:
			System.out.println("No se puede cambiar ese dato");
			break;
		}
    }
}

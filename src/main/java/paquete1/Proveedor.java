package paquete1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedor extends Persona{
    //Atributos
    private int    		id_proveedor;
    private String 		empresa;
    private String 		giro;
    private Conexion 	con;
    
    //Metodos
    public Proveedor(int id_proveedor, String empresa, String giro, int id_persona, Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int numero_Telefono, String correo, String rfc) {
        super(id_direccion, nombre, apellido_paterno, apellido_materno, numero_Telefono, correo, rfc);
        this.id_proveedor = id_proveedor;
        this.empresa = empresa;
        this.giro = giro;
    }

	public Proveedor() {
		super();
	}

	public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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
	
	public void insertProveedor (){
		String incertar = "INSERT INTO proveedor(id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc, id_proveedor, empresa, giro) "
				+"VALUES(?,?,?,?,?,?,?,?,?,?);";
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(incertar, Statement.RETURN_GENERATED_KEYS)){
			
			if (getId_direccion().getId_direccion()==0) {
				System.out.println("No se encuentra esta direccion");
				conn.close();
			} else {
				pstmt.setInt(1, getId_direccion().getId_direccion());
				pstmt.setString(2, getNombre());
				pstmt.setString(3, getApellido_paterno());
				pstmt.setString(4, getApellido_materno());
				pstmt.setInt(5, getNumero_Telefono());
				pstmt.setString(6, getCorreo());
				pstmt.setString(7, getRfc());
				pstmt.setInt(8, getId_proveedor());
				pstmt.setString(9, getEmpresa());
				pstmt.setString(10, getGiro());
			
				System.out.println(pstmt);
			
				pstmt.executeUpdate();
	        
				conn.close();
			}
			
			 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
	
	public void queryProveedor (){
		try (Connection conn = connect();
				Statement query = conn.createStatement();){
			ResultSet rs = query.executeQuery("SELECT * FROM proveedor;");
			if (rs == null){
				if(query != null) {
					System.out.println("Error1");
					query.close();
				}
				System.out.println("Error");
				conn.close();
			}
			else {
				while (rs.next()){	
					System.out.println("Encontro");
					System.out.println(
					   "|\t"+rs.getInt("id_persona")			+"\t|\t"+rs.getInt("id_direccion")
					+"\t|\t"+rs.getString("nombre")				+"\t|\t"+rs.getString("apellido_paterno")  
					+"\t|\t"+rs.getString("apellido_materno")	+"\t|\t"+rs.getInt("num_telefono")
					+"\t|\t"+rs.getString("correo")				+"\t|\t"+rs.getString("rfc")
					+"\t|\t"+rs.getInt("id_proveedor")			+"\t|\t"+rs.getString("empresa")
					+"\t|\t"+rs.getString("giro")				+"\t|");
				}
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
    }
	
	public void dropProveedor (int id){
		String eliminar = "DELETE FROM proveedor WHERE id_proveedor = ?";
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
	
	public void updateProveedor (int id, String nuevo,int valor){
		String alctualizar = null;
		switch (valor) {
		case 1:
			alctualizar = "UPDATE proveedor SET id_persona=? WHERE id_proveedor=?";
			
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
		case 2:
			alctualizar = "UPDATE proveedor SET id_direccion=? WHERE id_proveedor=?";
			
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
		case 3:
			alctualizar = "UPDATE proveedor SET nombre=? WHERE id_proveedor=?";
			
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
		case 4:
			alctualizar = "UPDATE proveedor SET apellido_paterno=? WHERE id_proveedor=?";
			
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
		case 5:
			alctualizar = "UPDATE proveedor SET apellido_materno=? WHERE id_proveedor=?";
			
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
		case 6:
			alctualizar = "UPDATE proveedor SET num_telefono=? WHERE id_proveedor=?";
			
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
		case 7:
			alctualizar = "UPDATE proveedor SET correo=? WHERE id_proveedor=?";
			
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
		case 8:
			alctualizar = "UPDATE proveedor SET rfc=? WHERE id_proveedor=?";
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
		case 9:
			alctualizar = "UPDATE proveedor SET id_proveedor=? WHERE id_proveedor=?";

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
		case 10:
			alctualizar = "UPDATE proveedor SET empresa=? WHERE id_proveedor=?";
			
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
		case 11:
			alctualizar = "UPDATE proveedor SET giro=? WHERE id_proveedor=?";

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

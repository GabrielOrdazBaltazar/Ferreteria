package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Empleado{
    //Atributos
    protected int id_empleado;
    private Persona id_persona;
    private Departamento id_departamento; //foranea
    private double sueldo;
    private String puesto;
	private Conexion con;
    
    //Metodos

    public Empleado(int id_empleado, Departamento id_departamento, double sueldo, String puesto, int id_persona, Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int numero_Telefono, String correo, String rfc) {
        super(id_persona, id_direccion, nombre, apellido_paterno, apellido_materno, numero_Telefono, correo, rfc);
        this.id_empleado = id_empleado;
        this.id_departamento = id_departamento;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Departamento getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Departamento id_departamento) {
        this.id_departamento = id_departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    public int getId_persona() {
        return id_persona;
    }

 
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    @Override
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    @Override
    public String getApellido_materno() {
        return apellido_materno;
    }

    @Override
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    @Override
    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    @Override
    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getRfc() {
        return rfc;
    }

    @Override
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
	public void insertEmpleado (){
		String insertar = "INSERT INTO proveedor(id_departamento, nombre, id_persona, nombre, apellido_paterno, apellido_materno, numero_Telefono, correo, rfc, id_empleado, sueldo, puesto) "
							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try(Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
			 pstmt.setInt(1, getId_departamento());
			 pstmt.setString(2, getNombre());
			 pstmt.setInt(3, getId_persona());
			 pstmt.setString(4, getNombre());
			 pstmt.setString(5, getApellido_paterno());
			 pstmt.setString(6, getApellido_materno());
			 pstmt.setInt(7, getNumero_Telefono());
			 pstmt.setString(8, getCorreo());
			 pstmt.setString(9, getRfc());
			 pstmt.setInt(10, getId_empleado());
			 pstmt.setDouble(11, getSueldo());
			 pstmt.setString(12, getPuesto());
			 System.out.println(pstmt);

			 pstmt.executeUpdate();

			 conn.close();

		} 
		catch (SQLException e) {
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
					System.out.println("Datos encontrados: ");
					System.out.println(
					   "|\t"+rs.getInt("id_departamento")		+"\t|\t"+rs.getInt("nombre")
					+"\t|\t"+rs.getString("id_persona")			+"|\t"+rs.getInt("nombre")
					+"\t|\t"+rs.getString("apellido_paterno")  	+"\t|\t"+rs.getString("apellido_materno")	
					+"\t|\t"+rs.getInt("num_telefono")			+"\t|\t"+rs.getString("correo")				
					+"\t|\t"+rs.getString("rfc")				+"\t|\t"+rs.getInt("id_empleado")			
					+"\t|\t"+rs.getString("sueldo")			+"\t|\t"+rs.getString("puesto")			 + "\t|");
				}
				conn.close();	 
			}
		}catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}
	}
	public void dropEmpleado (int id){
		String eliminar = "DELETE FROM Empleado WHERE id_empleado = ?";
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
	public void updateEmpleado (int id, String nuevo,int valor){
		String alctualizar = null;
		switch (valor) {
		case 1:
			alctualizar = "UPDATE Empleado SET id_departamento=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET nombre=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET id_persona=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET nombre=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET apellido_paterno=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET apellido_materno=? WHERE id_empleado=?";

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
		case 7:
			alctualizar = "UPDATE Empleado SET num_telefono=? WHERE id_empleado=?";

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
		case 8:
			alctualizar = "UPDATE Empleado SET correo=? WHERE id_empleado=?";

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
			alctualizar = "UPDATE Empleado SET rfc=? WHERE id_empleado=?";
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
		case 10:
			alctualizar = "UPDATE Empleado SET id_empleado=? WHERE id_empleado=?";

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
		case 11:
			alctualizar = "UPDATE Empleado SET sueldo=? WHERE id_empleado=?";

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
		case 12:
			alctualizar = "UPDATE Empleado SET puesto=? WHERE id_empleado=?";

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
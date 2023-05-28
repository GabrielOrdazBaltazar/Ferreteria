package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Departamento {
    //Atibuto
    private int    id_departamento;
    private String nombre;
    private Conexion con;
    
    //Metodos

    public Departamento(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
		public void insertEmpleado() {
			String insertar = "INSERT INTO empleado(id_empleado, nombre)" + "VALUES(?,?)";
			try(Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
					
					 pstmt.setInt(1, getId_departamento());
					 pstmt.setString(2, getNombre());
					 System.out.println(pstmt);
					 
					 pstmt.executeUpdate();
			         
					 conn.close();
					 
				} catch (SQLException e) {
					System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
				}
		    }
		public void queryDepartamento (){
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
						System.out.println("|\t"+rs.getInt("id_departamento")+"\t|\t"+rs.getString("nombre")+"\t|");
					}
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
	    }
		
		public void dropDepartamento (int id) {
			String eliminar = "DELETE FROM departamento WHERE id_departamento = ?";
			try(
				Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(eliminar)){
				
				 pstmt.setInt(1, id);
				 
				 System.out.println(pstmt);
				 
				 pstmt.executeUpdate();
		         
				 conn.close();
				 
			}
			catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
		}

		public void updateDepartamento (int id, String nuevo,int valor){
			String actualizar = null;
			switch (valor) {
			case 1:
				actualizar = "UPDATE departamento SET nombre=? WHERE id_departamento=?";

				try(
					Connection conn = connect();
					PreparedStatement pstmt = conn.prepareStatement(actualizar)){

					pstmt.setString(1, nuevo);
					pstmt.setInt(2, id);
					System.out.println(pstmt);
					pstmt.executeUpdate();
					if
						(pstmt.executeUpdate() > 0){
						System.out.println("Los datos han sido modificados con éxito");
				    }
					else
						{
				    	System.out.println("No se ha podido realizar la actualización de los datos\n");
						}
						conn.close();

				} catch (SQLException e) {
					System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
				}

				break;
			}
			
			}
}
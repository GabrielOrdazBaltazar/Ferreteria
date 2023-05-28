package clases;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistEmpleado {
	//atributos
    private Date fecha_inicio;
    private String puesto;
    private double sueldo;
    private Conexion con;
    
    //metodos
    public HistEmpleado(Empleado id_empleado, Persona id_persona, Departamento id_departamento, Date fecha_inicio, String puesto, double sueldo) {
    	super(id_empleado, id_persona, id_departamento);
        this.fecha_inicio = fecha_inicio;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
    public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public int getId_empleado() {
    	return id_empleado();
    }
    
    public void setId_empleado(int id_empleado) {
    	this.id_empleado = id_empleado;
    }

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
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
	public void insertHistoricoEmpleado() {
		String insertar = "INSERT INTO HistoricoEmpleado(id_empleado, id_persona, id_departamento, fecha_inicio, puesto, sueldo)" 
						+ "VALUES(?,?,?,?,?,?,?,?)";
		try(Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS)){
				
				 pstmt.setInt(1, getId_empleado());
				 pstmt.setInt(2, getId_persona());
				 pstmt.setInt(3, getId_Departamento());
				 pstmt.setDate(4, (java.sql.Date) getFecha_inicio());
				 pstmt.setString(5, getPuesto());
				 pstmt.setDouble(6, getSueldo());
				 System.out.println(pstmt);
				 
				 pstmt.executeUpdate();
		         
				 conn.close();
				 
			} catch (SQLException e) {
				System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
			}
	    }
	public void queryHistEmpleado (){
		try (Connection conn = connect();
				Statement query = conn.createStatement();){
			ResultSet rs = query.executeQuery("SELECT * FROM HistEmpleado Where fecha_inicio=?;");
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
					   "|\t"+rs.getInt("id_empleado")			+"\t|\t"+rs.getInt("fecha_inicio")
					+"\t|\t"+rs.getString("puesto")				+"\t|\t"+rs.getString("sueldo")	+"\t|");
				}
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		}

	}
}

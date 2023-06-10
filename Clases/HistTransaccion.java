package Clases;

public class HistTransaccion {
	
	private int id_histTransaccion;
	private String fecha;
	private float precio_unitario;
	private Conexion conex;
	
	public HistTransaccion(Conexion conex, int valor, int id_histTransaccion, String fecha, float precio_unitario) {
		this.id_histTransaccion = id_histTransaccion;
		this.fecha = fecha;
		this.precio_unitario = precio_unitario;
		Escojer(conex, valor);
	}
	
	 public HistTransaccion(Conexion conex, int valor, String fecha, float precio_unitario) { //El valor es el numero de la columna que representa el nuevo dato a cambiar en la tabla de la BD
		this.fecha = fecha;
		this.precio_unitario = precio_unitario;
        Escojer(conex, valor); 
	}
	    
    public HistTransaccion(Conexion conex,  int valor, int id_histTransaccion) {
    	this.id_histTransaccion = id_histTransaccion;
        Escojer(conex, valor); 
    }
	
	public HistTransaccion() {
		super();
	}
	
	public void Escojer(Conexion conex, int valor) {
		HistTransaccionSQL histTransaccionSQL = new HistTransaccionSQL(this);
		histTransaccionSQL.setConexion(conex);	
		switch (valor) {
		case 1:
			histTransaccionSQL.insertHistTransaccion(getFecha(), getPrecio_unitario());
			this.id_histTransaccion = histTransaccionSQL.getId_histTransaccion();
			break;
		case 2:
			histTransaccionSQL.buscarHistTransaccion(id_histTransaccion);
			break;
		case 3:
			histTransaccionSQL.dropHistTransaccion(id_histTransaccion);
			break;
		case 4:
			histTransaccionSQL.updateHistTransaccion(getId_histTransaccion(), getFecha(), getPrecio_unitario());
			break;
		case 5:
			histTransaccionSQL.consultarHistTransaccion();
			break;
		default:
			break;
		}
	}
	
	public void setId_histTransaccion(int id_histTransaccion) {
		this.id_histTransaccion = id_histTransaccion;
	}
	
	public int getId_histTransaccion() {
		return id_histTransaccion;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	public float getPrecio_unitario() {
		return precio_unitario;
	}
}

package Clases;

public class Sucursal {

		private int id_sucursal;
		private int id_direccion;
		private String nombre;
		
		public Sucursal(Conexion conex, int valor, int id_sucursal, int id_direccion, String nombre) {
			this.id_sucursal = id_sucursal;
			this.id_direccion = id_direccion;
			this.nombre = nombre;
			Escojer(conex, valor); 
		}
		
		public Sucursal(Conexion conex, int valor, int id_direccion, String nombre) { //El valor es el numero de la columna que representa el nuevo dato a cambiar en la tabla de la BD
			this.id_direccion = id_direccion;
			this.nombre = nombre;
	        Escojer(conex, valor); 
	    }
	    
	    public Sucursal(Conexion conex, int valor,  int id_sucursal) {
	    	this.id_sucursal = id_sucursal;
	        Escojer(conex, valor); 
	    }
		
		public Sucursal() {
			super();
		}
		
		public void Escojer(Conexion conex, int valor) {
	    	SucursalSQL sucursalSQL = new SucursalSQL(this);
	    	sucursalSQL.setConexion(conex);	
			switch (valor) {
			case 1:
				sucursalSQL.insertSucursal(getId_direccion(), getNombre());
				this.id_sucursal = sucursalSQL.getId_sucursal();
				break;
			case 2:
				sucursalSQL.obtener_IDSucursal(id_sucursal);
				break;
			case 3:
				sucursalSQL.buscarSucursal(id_sucursal);
				break;
			case 4:
				sucursalSQL.dropSucursal(id_sucursal);
				break;
			case 5:
				sucursalSQL.updateSucursal(getId_sucursal(), getId_direccion(), getNombre());
				break;
			case 6:
				sucursalSQL.consultarSucursal();
				break;
			default:
				break;
			}
		}
		
		public void setId_sucursal(int id_sucursal) {
			this.id_sucursal = id_sucursal;
		}
		
		public int getId_sucursal() {
			return id_sucursal;
		}
		
		public void setId_direccion(int id_direccion) {
			this.id_direccion = id_direccion;
		}
		
		public int getId_direccion() {
			return id_direccion;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getNombre() {
			return nombre;
		}
}

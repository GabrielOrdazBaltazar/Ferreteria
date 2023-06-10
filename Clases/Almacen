package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class Almacen {

    private int id_almacen;
    private int id_sucursal;
    private Conexion conex;

    public Almacen(Conexion conex, int valor, int id_almacen, int id_sucursal) {
        this.id_almacen = id_almacen;
    	this.id_sucursal = id_sucursal;
        Escojer(conex, valor); 
    }
    
    public Almacen(Conexion conex, int valor, int id_sucursal) { //El valor es el numero de la columna que representa el nuevo dato a cambiar en la tabla de la BD
        this.id_sucursal = id_sucursal;
        Escojer(conex, valor); 
    }
    
    public Almacen( int valor, Conexion conex, int id_almacen) {
    	this.id_almacen = id_almacen;
        Escojer(conex, valor); 
    }
    
    public Almacen() {
    	super();
    }
    
    public void Escojer(Conexion conex, int valor) {
    	AlmacenSQL almacenSQL = new AlmacenSQL(this);
    	almacenSQL.setConexion(conex);	
		switch (valor) {
		case 1:
			almacenSQL.insertAlmacen(getId_sucursal());
			this.id_almacen = almacenSQL.getId_almacen();
			break;
		case 2: //Esto no se ocupa, es extra
			almacenSQL.obtener_IDAlmacen(id_almacen);
			break;
		case 3:
			almacenSQL.buscarAlmacen(id_almacen);
			break;
		case 4:
			almacenSQL.dropAlmacen(id_almacen);
			break;
		case 5:
			almacenSQL.updateAlmacen(getId_almacen(), getId_sucursal());
			break;
		case 6:
			almacenSQL.consultarAlmacen();
			break;
		default:
			break;
		}
	}
    
    public int getId_almacen() {
        return id_almacen;
    }
    
    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }
    
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
}

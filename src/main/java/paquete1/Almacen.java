package paquete1;

public class Almacen {
    //Atributos
    private int      id_almacen;
    private Sucursal id_sucursal;
    
    //Metodos
    //Metodo constructor
    public Almacen(int id_almacen, Sucursal id_sucursal) {
        this.id_almacen  = id_almacen;
        this.id_sucursal = id_sucursal;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public Sucursal getId_sucursal() {
        return id_sucursal;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public void setId_sucursal(Sucursal id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    
}

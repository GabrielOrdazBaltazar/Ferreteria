package paquete1;

import java.util.Date;


public class Stock {
    //Atributos
    private Producto id_producto;
    private Almacen  id_almacen;
    private int      unidades_stock;
    private int      max_unidades;
    private int      min_unidades;
    private Date    fecha_ingreso = new Date();
    
    //Metodos

    public Stock(Producto id_producto, Almacen id_almacen, int unidades_stock, int max_unidades, int min_unidades, Date fecha_ingreso) {
        this.id_producto = id_producto;
        this.id_almacen = id_almacen;
        this.unidades_stock = unidades_stock;
        this.max_unidades = max_unidades;
        this.min_unidades = min_unidades;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Almacen getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(Almacen id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getUnidades_stock() {
        return unidades_stock;
    }

    public void setUnidades_stock(int unidades_stock) {
        this.unidades_stock = unidades_stock;
    }

    public int getMax_unidades() {
        return max_unidades;
    }

    public void setMax_unidades(int max_unidades) {
        this.max_unidades = max_unidades;
    }

    public int getMin_unidades() {
        return min_unidades;
    }

    public void setMin_unidades(int min_unidades) {
        this.min_unidades = min_unidades;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
}

package paquete1;

import java.util.Date;

public class HistCompra {
    //Atributos
    private int  id_HistCompra;
    private Date fecha;
    private double precio_unitario;
    
    //Metodos

    public HistCompra(int id_HistCompra, Date fecha, double precio_unitario) {
        this.id_HistCompra = id_HistCompra;
        this.fecha = fecha;
        this.precio_unitario = precio_unitario;
    }

    public int getId_HistCompra() {
        return id_HistCompra;
    }

    public void setId_HistCompra(int id_HistCompra) {
        this.id_HistCompra = id_HistCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
}

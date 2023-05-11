
package paquete1;

import java.util.Date;

public class HistTransaccion {
    private int id_HistTransaccion;
    private Date fecha = new Date();
    private double precio_unitario;
    
    //Metodos

    public HistTransaccion(int id_HistTransaccion, Date fecha, double precio_unitario) {
        this.id_HistTransaccion = id_HistTransaccion;
        this.fecha = fecha;
        this.precio_unitario = precio_unitario;
    }

    public int getId_HistTransaccion() {
        return id_HistTransaccion;
    }

    public void setId_HistTransaccion(int id_HistTransaccion) {
        this.id_HistTransaccion = id_HistTransaccion;
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

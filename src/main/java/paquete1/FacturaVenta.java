package paquete1;

import java.util.Date;

public class FacturaVenta {
    //Atributos
    private int id_FacturaVenta;
    private double subTotal;
    private double total;
    private Date fecha = new Date();
    private String hora;
    
    //Modulos

    public FacturaVenta(int id_FacturaVenta, double subTotal, double total, String hora) {
        this.id_FacturaVenta = id_FacturaVenta;
        this.subTotal = subTotal;
        this.total = total;
        this.hora = hora;
    }

    public int getId_FacturaVenta() {
        return id_FacturaVenta;
    }

    public void setId_FacturaVenta(int id_FacturaVenta) {
        this.id_FacturaVenta = id_FacturaVenta;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}

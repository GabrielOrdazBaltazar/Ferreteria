
package paquete1;

import java.util.Date;

public class DatosFacturaCompra {
    //Atributos
    private FacturaCompra id_facturaCompra;
    private double sub_Total;
    private double total;
    private Date fecha = new Date();
    
    //Modulos

    public DatosFacturaCompra(FacturaCompra id_facturaCompra, double sub_Total, double total) {
        this.id_facturaCompra = id_facturaCompra;
        this.sub_Total = sub_Total;
        this.total = total;
    }

    public FacturaCompra getId_facturaCompra() {
        return id_facturaCompra;
    }

    public void setId_facturaCompra(FacturaCompra id_facturaCompra) {
        this.id_facturaCompra = id_facturaCompra;
    }

    public double getSub_Total() {
        return sub_Total;
    }

    public void setSub_Total(double sub_Total) {
        this.sub_Total = sub_Total;
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
    
}


package paquete1;

public class FacturaCompra {
    //Aributos
    private int      id_facturaCompra;
    private Empleado id_comprador;
    
    //Metodos
    public FacturaCompra(int id_facturaCompra, Empleado id_comprador) {
        this.id_facturaCompra = id_facturaCompra;
        this.id_comprador = id_comprador;
    }

    public int getId_facturaCompra() {
        return id_facturaCompra;
    }

    public void setId_facturaCompra(int id_facturaCompra) {
        this.id_facturaCompra = id_facturaCompra;
    }

    public Empleado getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(Empleado id_comprador) {
        this.id_comprador = id_comprador;
    }
    
    
}

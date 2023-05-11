
package paquete1;

public class Transaccion {
    //Atributos
    private int id_transaccion;
    private Producto id_producto;
    private Empleado id_empleado;
    private Cliente  id_cliente;
    private FacturaVenta id_FacturaVenta;
    private HistTransaccion id_HistoricoTransaccion;
    private int unidades;
    
    //Modulos

    public Transaccion(int id_transaccion, Producto id_producto, Empleado id_empleado, Cliente id_cliente, FacturaVenta id_FacturaVenta, HistTransaccion id_HistoricoTransaccion, int unidades) {
        this.id_transaccion = id_transaccion;
        this.id_producto = id_producto;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.id_FacturaVenta = id_FacturaVenta;
        this.id_HistoricoTransaccion = id_HistoricoTransaccion;
        this.unidades = unidades;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public FacturaVenta getId_FacturaVenta() {
        return id_FacturaVenta;
    }

    public void setId_FacturaVenta(FacturaVenta id_FacturaVenta) {
        this.id_FacturaVenta = id_FacturaVenta;
    }

    public HistTransaccion getId_HistoricoTransaccion() {
        return id_HistoricoTransaccion;
    }

    public void setId_HistoricoTransaccion(HistTransaccion id_HistoricoTransaccion) {
        this.id_HistoricoTransaccion = id_HistoricoTransaccion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }


    
}

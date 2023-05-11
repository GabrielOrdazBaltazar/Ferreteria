package paquete1;

import java.util.Date;

public class Compra {
    //Atributos
    private int           id_compra;
    private Proveedor     id_proveedor;
    private Producto      id_producto;
    private FacturaCompra id_factura;
    private HistCompra    id_HistCompra;
    private int           unidades;
    private double        costo_unitario;
    private Date          fecha_pedido = new Date();
    private Date          fecha_entrega = new Date();
    
    //Metodos

    public Compra(int id_compra, Proveedor id_proveedor, Producto id_producto, FacturaCompra id_factura, HistCompra id_HistCompra, int unidades, double costo_unitario, Date fecha_pedido, Date fecha_entrega) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.id_producto = id_producto;
        this.id_factura = id_factura;
        this.id_HistCompra = id_HistCompra;
        this.unidades = unidades;
        this.costo_unitario = costo_unitario;
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public FacturaCompra getId_factura() {
        return id_factura;
    }

    public void setId_factura(FacturaCompra id_factura) {
        this.id_factura = id_factura;
    }

    public HistCompra getId_HistCompra() {
        return id_HistCompra;
    }

    public void setId_HistCompra(HistCompra id_HistCompra) {
        this.id_HistCompra = id_HistCompra;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    
    
    
}

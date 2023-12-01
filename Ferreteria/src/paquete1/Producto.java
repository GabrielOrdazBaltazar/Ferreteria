
package paquete1;

public class Producto {
    //Atributos
    private int    id_producto;
    private String nombre;
    private String descripcion;
    private String area_uso;
    private double precio_unitario;
    private String marca; 
    
    //Metodos
    public Producto(int id_producto, String nombre, String descripcion, String area_uso, double precio_unitario, String marca) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.area_uso = area_uso;
        this.precio_unitario = precio_unitario;
        this.marca = marca;
        
        //Ingresando datos a la base de datos
        paquete1.ProductoSQL prod = new paquete1.ProductoSQL();
        prod.ingresarProducto(id_producto, nombre, descripcion, area_uso, precio_unitario, marca);
    }
    
    public Producto(){
    
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea_uso() {
        return area_uso;
    }

    public void setArea_uso(String area_uso) {
        this.area_uso = area_uso;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}

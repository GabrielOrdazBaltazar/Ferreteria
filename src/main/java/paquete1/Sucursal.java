
package paquete1;

public class Sucursal {
    //Atributo
    private int       id_sucursal;
    private Direccion id_direccion;
    private String    nombre;
    
    //Metodos
    
    //Metodo constructor
    public Sucursal(int id_sucursal, Direccion id_direccion, String nombre) {
        this.id_sucursal = id_sucursal;
        this.id_direccion = id_direccion;
        this.nombre = nombre;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

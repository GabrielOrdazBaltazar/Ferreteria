package paquete1;

public class Proveedor extends Persona{
    //Atributos
    private int    id_proveedor;
    private String empresa;
    private String giro;
    
    //Metodos
    public Proveedor(int id_proveedor, String empresa, String giro, int id_persona, Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int numero_Telefono, String correo, String rfc) {
        super(id_persona, id_direccion, nombre, apellido_paterno, apellido_materno, numero_Telefono, correo, rfc);
        this.id_proveedor = id_proveedor;
        this.empresa = empresa;
        this.giro = giro;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


    
    
    
}

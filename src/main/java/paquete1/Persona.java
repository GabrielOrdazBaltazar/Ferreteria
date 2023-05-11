package paquete1;

public abstract class Persona {
    //Atributos
    protected int       id_persona;
    protected Direccion id_direccion;
    protected String    nombre;
    protected String    apellido_paterno;
    protected String    apellido_materno;
    protected int       numero_Telefono;
    protected String    correo;
    protected String    rfc;
    
    //Metodos 
    
    //Metodo constructor
    public Persona(int id_persona, Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int numero_Telefono, String correo, String rfc) {
        this.id_persona       = id_persona;
        this.id_direccion     = id_direccion;
        this.nombre           = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.numero_Telefono  = numero_Telefono;
        this.correo           = correo;
        this.rfc              = rfc;
    }

    public int getId_persona() {
        return id_persona;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    
    
}

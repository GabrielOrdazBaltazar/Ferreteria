package paquete1;

public class Persona {
    //Atributos
    protected  int       id_persona;
    protected  Direccion id_direccion;
    protected  String    nombre;
    protected  String    apellido_paterno;
    protected  String    apellido_materno;
    protected  long       num_telefono;
    protected  String    correo;
    protected  String    rfc;

    //Metodos

    public Persona(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, long num_telefono, String correo, String rfc) {
        this.id_direccion = id_direccion;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.num_telefono = num_telefono;
        this.correo = correo;
        this.rfc = rfc;
        
        //Ingesando a la base de datos
        paquete1.PersonaSQL per = new paquete1.PersonaSQL();
        per.ingresarPersona(id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc);
        this.id_persona = per.getId_persona();
    }
    
    public Persona(){
    
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

    public long getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
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


package paquete1;

public class Empleado extends Persona{
    //Atributos
    private int id_empleado;
    private Departamento id_departamento;
    private double sueldo;
    private String puesto;
    
    //Metodos

    public Empleado(int id_empleado, Departamento id_departamento, double sueldo, String puesto, int id_persona, Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int numero_Telefono, String correo, String rfc) {
        super(id_persona, id_direccion, nombre, apellido_paterno, apellido_materno, numero_Telefono, correo, rfc);
        this.id_empleado = id_empleado;
        this.id_departamento = id_departamento;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Departamento getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Departamento id_departamento) {
        this.id_departamento = id_departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public int getId_persona() {
        return id_persona;
    }

    @Override
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public Direccion getId_direccion() {
        return id_direccion;
    }

    @Override
    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    @Override
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    @Override
    public String getApellido_materno() {
        return apellido_materno;
    }

    @Override
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    @Override
    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    @Override
    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getRfc() {
        return rfc;
    }

    @Override
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    
}

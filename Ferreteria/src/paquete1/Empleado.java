
package paquete1;

public class Empleado extends Persona{
    //Atributos
    private int id_empleado;
    private Departamento id_departamento;
    private double sueldo;
    private String puesto;
    //Metodos

    public Empleado(){
    
    }
    
    public Empleado(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int num_telefono, String correo, String rfc,int id_empleado, Departamento id_departamento, double sueldo, String puesto) {
        super(id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc);
        this.id_departamento = id_departamento;
        this.id_empleado = id_empleado;
        this.sueldo = sueldo;
        this.puesto = puesto;
        int id_persona = this.getId_persona();
        //ingresar datos
        EmpleadoSQL empl = new EmpleadoSQL();
        empl.ingresarEmpleado(id_persona,id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc, id_empleado, id_departamento, sueldo, puesto);
        
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
}

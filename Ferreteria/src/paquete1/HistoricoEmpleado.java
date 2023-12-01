
package paquete1;

public class HistoricoEmpleado{
    //Variables 
    private Empleado id_empleado;
    private String   fecha;
    private String   puesto;
    private double   sueldo;
    
    //metodos

    public HistoricoEmpleado(Empleado id_empleado, String fecha, String puesto, double sueldo) {
        this.id_empleado = id_empleado;
        this.fecha = fecha;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public Empleado getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
}

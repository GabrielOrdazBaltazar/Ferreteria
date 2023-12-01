package paquete1;

public class Departamento {
    //Atibuto
    private int    id_departamento;
    private String nombre;
    private String Resultado;

    //Metodos
    public Departamento(){
    
    }
    
    public Departamento(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        
        //Ingresar a la base de datos
        DepartamentoSQL dep = new DepartamentoSQL();
        this.Resultado = dep.ingresarDepartamento(id_departamento, nombre);
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
}

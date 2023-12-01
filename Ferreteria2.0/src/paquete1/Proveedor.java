
package paquete1;

public class Proveedor extends Persona{
    //Atributos
    private int    id_proveedor;
    private String empresa;
    private String giro;    
    private String  Resultado;
    
    //Metodos
    public Proveedor(){
    
    }
    
    public Proveedor(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int num_telefono, String correo, String rfc,int id_proveedor,String empresa, String giro) {
        super(id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc);
        this.empresa = empresa; 
        this.giro = giro;
        this.id_proveedor = id_proveedor; 
        int id_persona = this.getId_persona();
        
        paquete1.ProveedorSQL prov = new paquete1.ProveedorSQL();
        prov.ingresarProveedor(id_persona,id_direccion, nombre, apellido_paterno, apellido_materno, num_telefono, correo, rfc,id_proveedor,empresa,giro);
               
        
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

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
}

package paquete1;

public class Direccion {
    //Atrinbutos
    private int	    id_direccion;
    private String  estado;
    private String  municipio;
    private int     codigo_postal;
    private String  no_exterior;
    private String  Resultado;

    //Metodos
    public Direccion(String estado, String municipio, int codigo_postal, String no_exterior) {
        this.estado = estado;
        this.municipio = municipio;
        this.codigo_postal = codigo_postal;
        this.no_exterior = no_exterior;
        //Guardamos en la BD
        paquete1.DireccionSQL dir = new paquete1.DireccionSQL();
        this.Resultado = dir.ingresarDireccion(estado,municipio,codigo_postal,no_exterior);
        this.id_direccion = dir.getId_direccion();    
    }

    public Direccion(){
    
    }
    
    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getNo_exterior() {
        return no_exterior;
    }

    public void setNo_exterior(String no_exterior) {
        this.no_exterior = no_exterior;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
    
}

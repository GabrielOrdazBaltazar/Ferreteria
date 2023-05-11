package paquete1;

public class Direccion {
    //Atrinbutos
    private int     id_direccion;
    private int     estado;
    private int     municipio;
    private int     codigo_postal;
    private String  no_exterior;
    
    //Metodos

    public Direccion(int id_direccion, int estado, int municipio, int codigo_postal, String no_exterior) {
        this.id_direccion = id_direccion;
        this.estado = estado;
        this.municipio = municipio;
        this.codigo_postal = codigo_postal;
        this.no_exterior = no_exterior;
    }
    
    public int getId_direccion() {
        return id_direccion;
    }

    public int getEstado() {
        return estado;
    }

    public int getMunicipio() {
        return municipio;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public String getNo_exterior() {
        return no_exterior;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setNo_exterior(String no_exterior) {
        this.no_exterior = no_exterior;
    }
    
    
}

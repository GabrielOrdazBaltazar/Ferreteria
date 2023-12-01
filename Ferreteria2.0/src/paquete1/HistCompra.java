package paquete1;

public class HistCompra {
    //Atributos
    private int    id_histcompra;
    private String fecha;
    private double precio_unitario;   
    private String  Resultado;
    //Metodos

    public HistCompra(String fecha, double precio_unitario) {
        this.fecha = fecha;
        this.precio_unitario = precio_unitario;
        
        //Ingresar a la base de datos
        HistCompraSQL hcomp = new HistCompraSQL();
        this.Resultado = hcomp.ingresarHistCoMPRA(fecha, precio_unitario);
        this.id_histcompra = hcomp.getId_histcompra();
    }
    
    public HistCompra() {
    
    }

    public int getId_histcompra() {
        return id_histcompra;
    }

    public void setId_histcompra(int id_histcompra) {
        this.id_histcompra = id_histcompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
     
    
}

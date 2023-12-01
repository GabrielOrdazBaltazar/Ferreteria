package paquete1;

public class Descuento {
    //Atributos
    private int id_descuento;
    private int contador;
    private int descuento_ClienteFrecuente;
    private double minCompra;
    private int descuento_volumen;
    
    //Metodos

    public Descuento(int descuento_ClienteFrecuente, double minCompra, int descuento_volumen) {
        this.descuento_ClienteFrecuente = descuento_ClienteFrecuente;
        this.minCompra = minCompra;
        this.descuento_volumen = descuento_volumen;
        //Ingresar a la Base de datos
        DescuentoSQL des = new DescuentoSQL();
        des.ingresarDescuennto(descuento_ClienteFrecuente, minCompra, descuento_volumen);
        this.id_descuento = des.getId_descuento();
        this.contador = des.getContador();
    }

    public Descuento(){
    
    }
    
    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getDescuento_ClienteFrecuente() {
        return descuento_ClienteFrecuente;
    }

    public void setDescuento_ClienteFrecuente(int descuento_ClienteFrecuente) {
        this.descuento_ClienteFrecuente = descuento_ClienteFrecuente;
    }

    public double getMinCompra() {
        return minCompra;
    }

    public void setMinCompra(double minCompra) {
        this.minCompra = minCompra;
    }

    public int getDescuento_volumen() {
        return descuento_volumen;
    }

    public void setDescuento_volumen(int descuento_volumen) {
        this.descuento_volumen = descuento_volumen;
    }
    
    
}

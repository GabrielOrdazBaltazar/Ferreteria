package paquete1;

public class Descuento {
    //Atributos
    private int    id_descuento;
    private int    contador;
    private int    descuento_Cliente_Frecuente;
    private double minCompra;
    private int    descuento_volumen;
    //Metodos

    public Descuento(int id_descuento, int contador, int descuento_Cliente_Frecuente, double minCompra, int descuento_volumen) {
        this.id_descuento = id_descuento;
        this.contador = contador;
        this.descuento_Cliente_Frecuente = descuento_Cliente_Frecuente;
        this.minCompra = minCompra;
        this.descuento_volumen = descuento_volumen;
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

    public int getDescuento_Cliente_Frecuente() {
        return descuento_Cliente_Frecuente;
    }

    public void setDescuento_Cliente_Frecuente(int descuento_Cliente_Frecuente) {
        this.descuento_Cliente_Frecuente = descuento_Cliente_Frecuente;
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

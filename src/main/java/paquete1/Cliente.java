package paquete1;

public class Cliente {
    //Atributos
    private int id_cliente;
    private Persona id_persona;
    private Descuento id_descuento;
    private String    tipo_Cliente;
    
    //Metodos

    public Cliente(int id_cliente, Persona id_persona, Descuento id_descuento, String tipo_Cliente) {
        this.id_cliente = id_cliente;
        this.id_persona = id_persona;
        this.id_descuento = id_descuento;
        this.tipo_Cliente = tipo_Cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    public Descuento getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Descuento id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getTipo_Cliente() {
        return tipo_Cliente;
    }

    public void setTipo_Cliente(String tipo_Cliente) {
        this.tipo_Cliente = tipo_Cliente;
    }
    
}

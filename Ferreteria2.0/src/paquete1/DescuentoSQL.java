package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class DescuentoSQL extends ConexionSQL{
    //Atributos
    private static int id_descuento;
    private static int contador;
    java.sql.Statement st;
    ResultSet rs;  
    
    //Metodos
    public DescuentoSQL() {
        
    }

    public int getId_descuento() {
        return id_descuento;
    }
    
    public int getContador() {
        return contador;
    }    
    
    //Ingresar datos de la direccion a la base de datos
    public String ingresarDescuennto(int descuento_ClienteFrecuente, double minCompra, int descuento_volumen){
        
        String res = ""; 
        try {
            //Ingresar datatos a la base de datos
            int contador = 1;
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into descuento(contador,descuento_clientefrecuente,mincompra,descuento_volumen) values('" +contador+ "','" +descuento_ClienteFrecuente+ "','" +minCompra+ "','" +descuento_volumen+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();
            
            //Ingresar datos a la clase
            st = conexion.createStatement();
            String sql1 = "select * from descuento where id_descuento =  (SELECT id_descuento FROM descuento ORDER BY id_descuento DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_descuento = (rs.getInt("id_descuento"));
                this.contador = (rs.getInt("contador"));
                res = "El registro se guardo correctamente";
            }else{
                res = "El registro no se guardo";
                System.out.println("No jalo amo");
            }     
            st.close();
            conexion.close();            
            
            //JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            res = "El registro no se guardo";
            System.out.println("El registro no se guardo " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }    
    
     //Buscar Direccion
    public Descuento buscarDescuento(int id_descuento){
        Descuento des = new Descuento();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from descuento where id_descuento = '"+id_descuento+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                des.setId_descuento(rs.getInt("id_descuento"));                
                des.setContador(rs.getInt("contador"));
                des.setDescuento_ClienteFrecuente(rs.getInt("descuento_clientefrecuente"));
                des.setMinCompra(rs.getDouble("mincompra"));
                des.setDescuento_volumen(rs.getInt("descuento_volumen"));
                des.setResultado("Se encontro registro");
            }else{
               
                des.setId_descuento(rs.getInt(""));
                des.setContador(rs.getInt(""));
                des.setResultado("No se encontro registro");
                //JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            
            }
            st.close();
            conexion.close();
        }catch(Exception e){ 
            des.setResultado("No se encontro registro");
            //JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return des;
    }

    //Actulizar Direccion
    public String actualizarDescuento(int id_descuento,int descuento_ClienteFrecuente, double minCompra, int descuento_volumen){
        String res = "";
        try{         
            Connection conexion = conectar();
            //int id = Integer.parseInt(id_producto);
            st = conexion.createStatement();
            String sql = "update descuento set contador = '"+contador+"',descuento_clientefrecuente = '"+descuento_ClienteFrecuente+"',mincompra = '"+minCompra+"',descuento_volumen = '"+descuento_volumen+"' where id_descuento = '"+id_descuento+"';";
            st.executeUpdate(sql);
            //JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();
            res = "El registro se actualizo correctamente";
        }catch(Exception e){
            res = "El registro NO se actualizo correctamente "; 
            System.out.println("El registro NO se actualizo correctamente " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
        return res;
    }

    //Eliminar direccion
    public String eliminarDescuento(int id_descuento){
        String res = "";
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from descuento where id_descuento = '"+id_descuento+"';";
            st.executeUpdate(sql);
            //JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();   
            res = "El registro se borro correctamente";
        }catch(Exception e){
            res = "El registro no se borro";
            System.out.println("El registro no se borro " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }      
    
}

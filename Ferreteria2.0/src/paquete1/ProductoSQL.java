package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ProductoSQL extends ConexionSQL{
    java.sql.Statement st;
    ResultSet rs;
    
    //Ingresar datos del Producto
    public String ingresarProducto(int id_producto,String nombre, String descripcion, String area_uso,double precio_unitario, String marca) {
        String res = "";
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into producto(id_producto,nombre,descripcion,area_uso,precio_unitario,marca) values('"+id_producto+"','" + nombre + "','" + descripcion + "','" + area_uso + "','" + precio_unitario + "','" + marca + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            res = "El registro se guardo correctamente";
            //JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            res = "El registro no se guardo";
            System.out.println("El registro no se guardo " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }  
    
    //Buscar producto
    public Producto buscarProducto(int id_producto){
        Producto prod = new Producto();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from producto where id_producto = '"+id_producto+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                prod.setId_producto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setArea_uso(rs.getString("area_uso"));
                prod.setPrecio_unitario(rs.getDouble("precio_unitario"));
                prod.setMarca(rs.getString("marca"));
                prod.setResultado("Se encontro registro");
            }else{
                prod.setId_producto(0);
                prod.setNombre("");
                prod.setDescripcion("");
                prod.setArea_uso("");
                prod.setPrecio_unitario(0);
                prod.setMarca("");   
                prod.setResultado("No se encontro registro");
                //JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){ 
            prod.setResultado("No se encontro registro");
            System.out.println("Error en e sistema de busqueda " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
            prod.setId_producto(0);
            prod.setNombre("");
            prod.setDescripcion("");
            prod.setArea_uso("");
            prod.setPrecio_unitario(0);
            prod.setMarca(""); 
        }
        return prod;
    }
    
    //Actulizar producto
    public String actualizarProducto(int id_producto,String nombre, String descripcion, String area_uso, double precio_unitario, String marca){
        String res = "";
        try{
            Connection conexion = conectar();
            //int id = Integer.parseInt(id_producto);
            st = conexion.createStatement();
            String sql = "update producto set nombre = '"+nombre+"',descripcion = '"+descripcion+"',area_uso = '"+area_uso+"',precio_unitario = '"+precio_unitario+"',marca = '"+marca+"' where id_producto = '"+id_producto+"';";
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
    
    //Eliminar Producto
    public String eliminarProducto(int id_producto){
        String res = "";
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from producto where id_producto = '"+id_producto+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
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

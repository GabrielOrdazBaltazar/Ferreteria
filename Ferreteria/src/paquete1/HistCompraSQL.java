package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class HistCompraSQL extends ConexionSQL{
    //Atributos
    private static int id_histcompra;
    java.sql.Statement st;
    ResultSet rs;
    
    //Metodos
    public HistCompraSQL() {
        
    }

    public int getId_histcompra() {
        return id_histcompra;
    }
    
    //Ingresar datos de la direccion a la base de datos
    public HistCompra ingresarHistCoMPRA(String fecha, double precio_unitario){
        HistCompra hcomp = new HistCompra();
        try {
            //Ingresar datatos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into histcompra(fecha,precio_unitario) values('" +fecha+ "','" +precio_unitario+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();
            
            //Ingresar datos a la clase
            st = conexion.createStatement();
            String sql1 = "select * from histcompra where id_histcompra =  (SELECT id_histcompra FROM public.histcompra ORDER BY id_histcompra DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_histcompra = (rs.getInt("id_histcompra"));

            }else{
                System.out.println("No jalo amo");
            }     
            st.close();
            conexion.close();            
            
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return hcomp;
    }  
    
    //Buscar HistCompra
    public HistCompra buscarHistCompra(int id_histcompra){
        HistCompra hcomp = new HistCompra();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from histcompra where id_histcompra = '"+id_histcompra+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                hcomp.setId_histcompra(rs.getInt("id_histcompra"));                
                hcomp.setFecha(rs.getString("fecha"));
                hcomp.setPrecio_unitario(rs.getDouble("precio_unitario"));
                     
            }else{
                
                hcomp.setId_histcompra(rs.getInt(""));                
                hcomp.setFecha(rs.getString(""));
                hcomp.setPrecio_unitario(rs.getDouble(0));  
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return hcomp;
    }  
    
    //Actulizar Historico compra
    public void actualizarHistCompra(int id_histcompra,String fecha, double precio_unitario){
        try{         
            Connection conexion = conectar();
            //int id = Integer.parseInt(id_producto);
            st = conexion.createStatement();
            String sql = "update histcompra set fecha = '"+fecha+"',precio_unitario = '"+precio_unitario+"' where id_histcompra = '"+id_histcompra+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }  
    
    //Eliminar Historico compra
    public void eliminarHistCompra(int id_histcompra){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from histcompra where id_histcompra = '"+id_histcompra+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }    
    
}

package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class DireccionSQL extends ConexionSQL{
    //variables
    private static int id_direccion;
    java.sql.Statement st;
    ResultSet rs;

    //Constructor
    public DireccionSQL(){
    
    }
    
    public int getId_direccion() {
        return id_direccion;
    }    
    
    //Ingresar datos de la direccion a la base de datos
    public Direccion ingresarDireccion(String estado, String municipio,int codigo_postal, String no_exterior){
        Direccion dir = new Direccion();
        try {
            //Ingresar datatos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into direccion(estado,municipio,codigo_postal,no_exterior) values('" +estado+ "','" +municipio+ "','" +codigo_postal+ "','" +no_exterior+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();
            
            //Ingresar datos a la clase
            st = conexion.createStatement();
            String sql1 = "select * from direccion where id_direccion =  (SELECT id_direccion FROM public.direccion ORDER BY id_direccion DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_direccion = (rs.getInt("id_direccion"));

            }else{
                System.out.println("No jalo amo");
            }     
            st.close();
            conexion.close();            
            
            //JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return dir;
    }
    
    //Buscar Direccion
    public Direccion buscarDireccion(int id_direccion){
        Direccion dir = new Direccion();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from direccion where id_direccion = '"+id_direccion+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                dir.setId_direccion(rs.getInt("id_direccion"));                
                dir.setEstado(rs.getString("estado"));
                dir.setMunicipio(rs.getString("municipio"));
                dir.setCodigo_postal(rs.getInt("codigo_postal"));
                dir.setNo_exterior(rs.getString("no_exterior"));
                     
            }else{
                
                dir.setId_direccion(rs.getInt(""));
                dir.setEstado(rs.getString(""));
                dir.setMunicipio(rs.getString(""));
                dir.setCodigo_postal(rs.getInt(""));
                dir.setNo_exterior(rs.getString(""));   
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return dir;
    }  
    
    //Actulizar Direccion
    public void actualizarDireccion(int id_direccion,String estado, String municipio,int codigo_postal, String no_exterior){
        try{         
            Connection conexion = conectar();
            //int id = Integer.parseInt(id_producto);
            st = conexion.createStatement();
            String sql = "update direccion set estado = '"+estado+"',municipio = '"+municipio+"',codigo_postal = '"+codigo_postal+"',no_exterior = '"+no_exterior+"' where id_direccion = '"+id_direccion+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }

    //Eliminar direccion
    public void eliminarDireccion(int id_direccion){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from direccion where id_direccion = '"+id_direccion+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }     
}

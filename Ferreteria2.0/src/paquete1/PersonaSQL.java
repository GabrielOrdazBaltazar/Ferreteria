
package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class PersonaSQL extends ConexionSQL{
    //Atributos
    protected static int id_persona; 
    java.sql.Statement st;
    ResultSet rs; 
    
    //Metodos  
    public int getId_persona() {
        return id_persona;
    }  
    
    public void PersonaSQL(){
    
    }
    
    //Ingresar datos de Persona
    public void ingresarPersona(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,long num_telefono,String correo,String rfc) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            int id = id_direccion.getId_direccion();
            String sql = "insert into persona(id_direccion,nombre,apellido_paterno,apellido_materno,num_telefono,correo,rfc) values('"+id+"','" +nombre+ "','" +apellido_paterno+ "','" +apellido_materno+ "','" +num_telefono+ "','" +correo+ "','"+rfc+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            
            //Ingresar datos a la clase
            conexion = conectar();
            st = conexion.createStatement();
            String sql1 = "select * from persona where id_persona =  (SELECT id_persona FROM persona ORDER BY id_direccion DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_persona = (rs.getInt("id_persona"));

            }else{
                System.out.println("No jalo amo");
            }     
            st.close();
            conexion.close(); 
            
            //JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    //Buscar Direccion
    public Persona buscarPersona(int id_persona){
        DireccionSQL dir = new DireccionSQL();
        Direccion dir1 = new Direccion();
        Persona per = new Persona();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from persona where id_persona = '"+id_persona+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                per.setId_persona(rs.getInt("id_persona"));
                per.setId_direccion(dir1);
                per.setNombre(rs.getString("nombre"));
                per.setApellido_paterno(rs.getString("apellido_paterno"));
                per.setApellido_materno(rs.getString("apellido_materno"));
                per.setNum_telefono(rs.getInt("num_telefono"));
                per.setCorreo(rs.getString("correo"));
                per.setRfc(rs.getString("rfc"));
            }else{
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                per.setId_persona(rs.getInt(""));
                per.setId_direccion(dir1);
                per.setNombre(rs.getString(""));
                per.setApellido_paterno(rs.getString(""));
                per.setApellido_materno(rs.getString(""));
                per.setNum_telefono(rs.getInt(""));
                per.setCorreo(rs.getString(""));
                per.setRfc(rs.getString("")); 
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);                     
        }
        return per;
    }  
    
    //Actulizar Direccion
    public void actualizarPersona(int id_persona,Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,int num_telefono,String correo,String rfc){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update persona set nombre = '"+nombre+"',apellido_paterno = '"+apellido_paterno+"',apellido_materno = '"+apellido_materno+"',num_telefono = '"+num_telefono+"',correo = '"+correo+"',rfc = '"+rfc+"' where id_persona = '"+id_persona+"';";
            st.executeUpdate(sql);
            
            DireccionSQL dir = new DireccionSQL();
            dir.actualizarDireccion(id_direccion.getId_direccion(),id_direccion.getEstado(), id_direccion.getMunicipio(), id_direccion.getCodigo_postal(), id_direccion.getNo_exterior()); 
            
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    } 
    
    public void eliminarPersona(int id_persona,int id_direccion){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from persona where id_persona = '"+id_persona+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();      
            
            DireccionSQL dir = new DireccionSQL();
            dir.eliminarDireccion(id_direccion);            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }     
}

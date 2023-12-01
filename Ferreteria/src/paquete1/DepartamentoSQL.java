
package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class DepartamentoSQL extends ConexionSQL{
    //variables
    private static int id_departamento;
    java.sql.Statement st;
    ResultSet rs;    

    public DepartamentoSQL() {
        
    }

    public static int getId_departamento() {
        return id_departamento;
    }
    
    //Ingresar datos de departamento a la base de datos
    public Departamento ingresarDepartamento(int id_departamento, String nombre){
        Departamento dep = new Departamento();
        try {
            //Ingresar datatos a la base de datos
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into departamento(id_departamento,nombre) values('" +id_departamento+ "','" +nombre+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            conexion = conectar();
                      
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return dep;
    }   
    
    //Buscar Departamento
    public Departamento buscarDepartamento(int id_departamento){
        Departamento dep = new Departamento();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from departamento where id_departamento = '"+id_departamento+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                dep.setId_departamento(rs.getInt("id_departamento"));
                dep.setNombre(rs.getString("nombre"));       
            }else{
                dep.setId_departamento(rs.getInt(""));
                dep.setNombre(rs.getString(""));   
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);
                     
        }
        return dep;
    }      
    
    //Actulizar Departamento
    public void actualizarDepartamento(int id_departamento, String nombre){
        try{         
            Connection conexion = conectar();
            //int id = Integer.parseInt(id_producto);
            st = conexion.createStatement();
            String sql = "update departamento set  nombre = '"+nombre+"' where id_departamento = '"+id_departamento+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }  
    
    //Eliminar Departamento
    public void eliminarDepartamento(int id_departamento){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from departamento where id_departamento = '"+id_departamento+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }     
}

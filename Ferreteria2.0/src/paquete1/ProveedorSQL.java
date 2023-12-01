package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ProveedorSQL extends ConexionSQL{
    //Variables
    protected static int id_proveedor; 
    java.sql.Statement st;
    ResultSet rs; 

    //Metodos
    public ProveedorSQL() {
    
    }

    public static int getId_proveedor() {
        return id_proveedor;
    }
    
    //Ingresar datos de Persona
    public String ingresarProveedor(int id_persona,Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,int num_telefono,String correo,String rfc,int id_proveedor,String empresa,String giro) {
        String res = ""; 
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            int id = id_direccion.getId_direccion();
            String sql = "insert into proveedor(id_persona,id_direccion,nombre,apellido_paterno,apellido_materno,num_telefono,correo,rfc,id_proveedor,empresa,giro) values('"+id_persona+"','"+id+"','" +nombre+ "','" +apellido_paterno+ "','" +apellido_materno+ "','" +num_telefono+ "','" +correo+ "','"+rfc+"','"+id_proveedor+"','"+empresa+"','"+giro+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            
            //Ingresar datos a la clase
            conexion = conectar();
            st = conexion.createStatement();
            String sql1 = "select * from proveedor where id_proveedor =  (SELECT id_proveedor FROM proveedor ORDER BY id_proveedor DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_proveedor = (rs.getInt("id_proveedor"));
                res = "El registro se guardo correctamente";
            }else{
                System.out.println("No jalo amo");
                res = "El registro no se guardo";
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
    public Proveedor buscarProveedor(int id_proveedor){
        DireccionSQL dir = new DireccionSQL();
        Direccion dir1 = new Direccion();
        Proveedor prov = new Proveedor();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from proveedor where id_proveedor = '"+id_proveedor+"'"; 
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                prov.setId_persona(rs.getInt("id_persona"));
                prov.setId_direccion(dir1);
                prov.setNombre(rs.getString("nombre"));
                prov.setApellido_paterno(rs.getString("apellido_paterno"));
                prov.setApellido_materno(rs.getString("apellido_materno"));
                prov.setNum_telefono(rs.getInt("num_telefono"));
                prov.setCorreo(rs.getString("correo"));
                prov.setRfc(rs.getString("rfc"));
                prov.setId_proveedor(rs.getInt("id_proveedor"));
                prov.setEmpresa(rs.getString("empresa"));
                prov.setGiro(rs.getString("giro"));
                prov.setResultado("Se encontro registro");
            }else{
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                prov.setId_persona(rs.getInt(""));
                prov.setId_direccion(dir1);
                prov.setNombre(rs.getString(""));
                prov.setApellido_paterno(rs.getString(""));
                prov.setApellido_materno(rs.getString(""));
                prov.setNum_telefono(rs.getInt(""));
                prov.setCorreo(rs.getString(""));
                prov.setRfc(rs.getString("")); 
                prov.setId_proveedor(rs.getInt(""));
                prov.setEmpresa(rs.getString(""));
                prov.setGiro(rs.getString("")); 
                prov.setResultado("No se encontro registro");
                //JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){
            prov.setResultado("No se encontro registro");
            System.out.println("Error en e sistema de busqueda " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);                     
        }
        return prov;
    }      

    //Actulizar Proveedor
    public String actualizarProveedor(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,int num_telefono,String correo,String rfc,int id_proveedor,String empresa,String giro){
        String res = "";
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update proveedor set nombre = '"+nombre+"',apellido_paterno = '"+apellido_paterno+"',apellido_materno = '"+apellido_materno+"',num_telefono = '"+num_telefono+"',correo = '"+correo+"',rfc = '"+rfc+"',empresa = '"+empresa+"',giro = '"+giro+"' where id_proveedor = '"+id_proveedor+"';";
            st.executeUpdate(sql);
            DireccionSQL dir = new DireccionSQL();
            dir.actualizarDireccion(id_direccion.getId_direccion(),id_direccion.getEstado(), id_direccion.getMunicipio(), id_direccion.getCodigo_postal(), id_direccion.getNo_exterior()); 
            
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
    
    public String eliminarProveedor(int id_proveedor,int id_direccion){
        String res = "";
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from proveedor where id_proveedor = '"+id_proveedor+"';";
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

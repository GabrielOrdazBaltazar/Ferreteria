
package paquete1;

//Librerias

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Random;

public class EmpleadoSQL extends ConexionSQL{
    //Variables
    protected static int id_empleado; 
    java.sql.Statement st;
    ResultSet rs; 

    //Metodos
    public EmpleadoSQL() {
    
    }

    public static int getId_empleado() {
        return id_empleado;
    }    
    
    //Ingresar datos de Persona
    public void ingresarEmpleado(int id_persona,Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int num_telefono, String correo, String rfc,int id_empleado, Departamento id_departamento, double sueldo, String puesto) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            int id = id_direccion.getId_direccion();
            int id_dep = id_departamento.getId_departamento();
            String sql = "insert into empleado(id_persona,id_direccion,nombre,apellido_paterno,apellido_materno,num_telefono,correo,rfc,id_empleado,id_departamento,sueldo,puesto) values('"+id_persona+"','"+id+"','" +nombre+ "','" +apellido_paterno+ "','" +apellido_materno+ "','" +num_telefono+ "','" +correo+ "','"+rfc+"','"+id_empleado+"','"+id_dep+"','"+sueldo+"','"+puesto+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            
            //Ingresar datos a la clase
            conexion = conectar();
            st = conexion.createStatement();
            String sql1 = "select * from empleado where id_empleado =  (SELECT id_empleado FROM departamento ORDER BY id_departamento DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_empleado = (rs.getInt("id_empleado"));

            }else{
                System.out.println("ya jalo amo");
            }     
            st.close();
            conexion.close(); 
            
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }  
       
    
    //Buscar Direccion
    public Empleado buscarEmpleado(int id_empleado){
        DireccionSQL     dir  = new DireccionSQL();
        Direccion        dir1 = new Direccion();
        DepartamentoSQL  dep  = new DepartamentoSQL();
        Departamento     dep1 = new Departamento();
        Empleado         emp = new Empleado();
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            if(id_empleado <11500){
                String sql = "select * from empleado_particion_01 where id_empleado = '"+id_empleado+"'"; 
                rs = st.executeQuery(sql);            
            }else{
                if(id_empleado <21500){
                    String sql = "select * from empleado_particion_02 where id_empleado = '"+id_empleado+"'"; 
                    rs = st.executeQuery(sql);            
                }else{
                    if(id_empleado <21522){
                        String sql = "select * from empleado_particion_03 where id_empleado = '"+id_empleado+"'"; 
                        rs = st.executeQuery(sql);            
                    }else{
                        if(id_empleado <215099){
                            String sql = "select * from empleado_particion_04 where id_empleado = '"+id_empleado+"'"; 
                            rs = st.executeQuery(sql);            
                        }else{
                            if(id_empleado <216000){
                                String sql = "select * from empleado_particion_05 where id_empleado = '"+id_empleado+"'"; 
                                rs = st.executeQuery(sql);            
                            }                           
                        }                      
                    }                  
                
                }            
            
            }
                            if(id_empleado >200000){
                                String sql = "select * from empleado where id_empleado = '"+id_empleado+"'"; 
                                rs = st.executeQuery(sql);            
                            }              

            if(rs.next()){
                
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                int id_dep = rs.getInt("id_departamento");
                dep1 = dep.buscarDepartamento(id_dep);
                
                emp.setId_persona(rs.getInt("id_persona"));
                emp.setId_direccion(dir1);
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido_paterno(rs.getString("apellido_paterno"));
                emp.setApellido_materno(rs.getString("apellido_materno"));
                emp.setNum_telefono(rs.getInt("num_telefono"));
                emp.setCorreo(rs.getString("correo"));
                emp.setRfc(rs.getString("rfc"));
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setId_departamento(dep1);
                emp.setSueldo(rs.getDouble("sueldo"));
                emp.setPuesto(rs.getString("puesto"));
                
            }else{
                int id_dir = rs.getInt("id_direccion");
                dir1 = dir.buscarDireccion(id_dir);
                
                int id_dep = rs.getInt("id_departamento");
                dep1 = dep.buscarDepartamento(id_dep);
                
                emp.setId_persona(rs.getInt("id_persona"));
                emp.setId_direccion(dir1);
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido_paterno(rs.getString("apellido_paterno"));
                emp.setApellido_materno(rs.getString("apellido_materno"));
                emp.setNum_telefono(rs.getInt("num_telefono"));
                emp.setCorreo(rs.getString("correo"));
                emp.setRfc(rs.getString("rfc"));
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setId_departamento(dep1);
                emp.setSueldo(rs.getDouble("sueldo"));
                emp.setPuesto(rs.getString("puesto"));               
                JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){           
                JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);                     
        }
        return emp;
    }      


    public void actualizarEmpleado(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,int num_telefono,String correo,String rfc,int id_empleado, Departamento id_departamento, double sueldo, String puesto){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update empleado set nombre = '"+nombre+"',apellido_paterno = '"+apellido_paterno+"',apellido_materno = '"+apellido_materno+"',num_telefono = '"+num_telefono+"',correo = '"+correo+"',rfc = '"+rfc+"',sueldo = '"+sueldo+"',puesto = '"+puesto+"' where id_empleado = '"+id_empleado+"';";
            st.executeUpdate(sql);
            
            DireccionSQL dir = new DireccionSQL();
            dir.actualizarDireccion(id_direccion.getId_direccion(), id_direccion.getEstado(), id_direccion.getMunicipio(), id_direccion.getCodigo_postal(), id_direccion.getNo_exterior());
            
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }
    
    //Eliminar Empleado
    public void eliminarEmpleado(int id_empleado,int id_direccion){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from empleado where id_empleado = '"+id_empleado+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se borro correctamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();      
                      
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro no se borro "+e,"Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }  
 
     
}


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
    public String ingresarEmpleado(int id_persona,Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno, int num_telefono, String correo, String rfc,int id_empleado, Departamento id_departamento, double sueldo, String puesto) {
        String res = ""; 
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            int id = id_direccion.getId_direccion();
            int id_dep = id_departamento.getId_departamento();
            String sql = "insert into empleado(id_persona,id_direccion,nombre,apellido_paterno,apellido_materno,num_telefono,correo,rfc,id_empleado,id_departamento,sueldo,puesto) values(120304,120849,Carlos,Vargas,Ramos,43788,gabriel6151@gmail.com,TBT359372GWW,315101,1236,3740.0436884231362,Asistente Administrativo);";
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
                res = "El registro se guardo correctamente";
            }else{
                System.out.println("No jalo amo");
                res = "El registro no se guardo";
            }     
            st.close();
            conexion.close(); 
            
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            res = "El registro no se guardo";
            System.out.println("El registro no se guardo " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return res;
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
                emp.setResultado("Se encontro registro");
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
                emp.setResultado("No se encontro registro");
                //JOptionPane.showMessageDialog(null,"No se encontro registro ","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){ 
            emp.setResultado("No se encontro registro");
            System.out.println("Error en e sistema de busqueda " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Error en e sistema de busqueda "+e,"Error",JOptionPane.ERROR_MESSAGE);                     
        }
        return emp;
    }      


    public void actualizarEmpleado(Direccion id_direccion, String nombre, String apellido_paterno, String apellido_materno,int num_telefono,String correo,String rfc,int id_empleado, int id_departamento, double sueldo, String puesto){
        try{         
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update empleado set nombre = '"+nombre+"',apellido_paterno = '"+apellido_paterno+"',apellido_materno = '"+apellido_materno+"',num_telefono = '"+num_telefono+"',correo = '"+correo+"',rfc = '"+rfc+"',sueldo = '"+sueldo+"',puesto = '"+puesto+"', id_departamento = '"+id_departamento+"' where id_empleado = '"+id_empleado+"';";
            st.executeUpdate(sql);
            /*
            DireccionSQL dir = new DireccionSQL();
            dir.actualizarDireccion(id_direccion.getId_direccion(), id_direccion.getEstado(), id_direccion.getMunicipio(), id_direccion.getCodigo_postal(), id_direccion.getNo_exterior());
            */
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente","Actualizado",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El registro NO se actualizo correctamente "+ e,"Error",JOptionPane.ERROR_MESSAGE);
        
        } 
    }
    
    //Eliminar Empleado
    public String eliminarEmpleado(int id_empleado,int id_direccion){
        String res = "";
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from empleado where id_empleado = '"+id_empleado+"';";
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

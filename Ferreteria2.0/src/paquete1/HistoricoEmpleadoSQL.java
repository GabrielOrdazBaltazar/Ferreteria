package paquete1;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class HistoricoEmpleadoSQL extends ConexionSQL{
    
        //Variables 
    java.sql.Statement st;
    ResultSet rs; 
    
    //Ingresar datos de Persona
    public void ingresarHistorico(int id_empleado, String fecha_inicio, double sueldo, String puesto) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();

            String sql = "insert into histempleado(id_empleado,fecha_inicio,sueldo,puesto) values('"+id_empleado+"','"+fecha_inicio+"','"+sueldo+"','"+puesto+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            
            
            //JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    
    public void TrigerHistEmpleado(int id_empleado, String fecha_inicio, double sueldo, String puesto){
        String sql = "create function TR_HistEmpleado() returns Trigger "
                + "as "
                + "$$ begin insert into histempleado values(old.id_empleado,new.CURRENT_DATE,old.sueldo, old.puesto)"
                + "return new"
                + " End $$"
                + "Language plpgsql;"
                + "create trigger TR_Update before Update on empleado"
                + "for each row"
                + "execute procedure TR_HistEmpleado();";
    }
}

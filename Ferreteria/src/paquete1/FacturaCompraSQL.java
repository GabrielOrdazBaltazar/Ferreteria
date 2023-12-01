
package paquete1;

//Librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class FacturaCompraSQL extends ConexionSQL{
    //Variables
    protected int id_facturaCompra; 
    java.sql.Statement st;
    ResultSet rs; 

    public int getId_facturaCompra() {
        return id_facturaCompra;
    }

    public void setId_facturaCompra(int id_facturaCompra) {
        this.id_facturaCompra = id_facturaCompra;
    }

    public FacturaCompraSQL(){
    
    }
    
    //Ingresar datos de Persona
    public void ingresarFacturaCompra(int factura_empleado) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();

            String sql = "insert into facturacompra(id_empleado) values('"+factura_empleado+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            
            //Ingresar datos a la clase
            conexion = conectar();
            st = conexion.createStatement();
            String sql1 = "select * from facturacompra where id_facturacompra =  (SELECT id_facturacompra FROM facturacompra ORDER BY id_facturacompra DESC LIMIT 1);";
            rs = st.executeQuery(sql1);
            if(rs.next()){
                //Guardamos El id en el la clase
                this.id_facturaCompra = (rs.getInt("id_facturacompra"));

            }else{
                System.out.println("No jalo amo");
            }     
            st.close();
            conexion.close(); 
            
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }      
}

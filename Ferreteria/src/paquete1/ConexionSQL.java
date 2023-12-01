package paquete1;

//Librerias
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/bdferreteria";
    String usuario = "postgres";
    String clave = "tachyeldragon123";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario,clave);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar "+e," Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }    
}

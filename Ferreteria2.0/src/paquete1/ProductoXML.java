package paquete1;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import paquete1.ConexionSQL;

public class ProductoXML extends ConexionSQL{

	/*
	public Connection connect() throws SQLException {
		
        return DriverManager.getConnection(getCon().getUrl(), getCon().getUsu(), getCon().getCon());
    }
	*/
	public void CrearProductoXML(int id_prod, String NombreProd) {
		String comando = "select * from cast ((select * from query_to_xml( 'select * from producto where id_producto = '||?,true,false,'')) as varchar)";
		//select * from cast ((select * from query_to_xml( 'select * from modificacion_contrato where id_contrato = (select contrato from empleado where rfc = '||:rfc||')',true,false,'')) as varchar)
		ResultSet rs = null;
		String A;
		try(
			Connection conexion = conectar();
			PreparedStatement pstmt = conexion.prepareStatement(comando)){
			
			pstmt.setInt(1, id_prod);
			rs = pstmt.executeQuery();
			System.out.println(NombreProd);
			if (rs.next()) {
				A = rs.getString("query_to_xml");
				Document document = convertStringToXml(A);
				
				escribirArchivo(document, NombreProd + ".xml");
                                
				
				
				System.out.println(A);
			} else {
				if(rs != null) rs.close();
				conexion.close();
			}

			System.out.println();  
			
			conexion.close();
				 
		} catch (SQLException e) {
			System.out.println("No se pudo conectar con la base de datos. Error: "+e.getMessage());
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Document convertStringToXml(String xmlString) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder builder = dbf.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            
            return doc;

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }
	
	public void escribirArchivo(Document documento, String fileName) throws TransformerException {
        // Creamos el objecto transformador
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
  

        // Archivo donde almacenaremos el XML
        File archivo = new File(new File("C:\\Users\\tachy\\Downloads\\Uaemex\\noveno\\Bases de datos avanzadas\\proyecto\\9)version").getAbsolutePath()+"/XML/"+fileName);
        // Fuente de datos, en este caso el documento XML
        DOMSource source = new DOMSource(documento);
        // Resultado, el cual almacena en el archivo indicado
        StreamResult result = new StreamResult(archivo);

        // Transformamos de ña fuente DOM a el resultado, lo que almacena todo en el archivo
        transformer.transform(source, result);
    }
}

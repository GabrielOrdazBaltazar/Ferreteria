import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
public class InsertEmpleadoRegistros {
    
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/bdferreteria"; // Reemplaza con la URL de tu base de datos
        String username = "postgres"; // Reemplaza con tu nombre de usuario de la base de datos
        String password = "tachyeldragon123"; // Reemplaza con tu contraseña de la base de datos
        
        try {
            
            String[] nombres = new String[100];
            String[] apellidos = new String[100];
            String[] numerosTelefono = new String[100];
            String[] correosElectronicos = new String[100];
            String[] puestosTrabajo = new String[100]; 
            double[] sueldos = new double[100];
            int cantidadRFCs = 1000000;
            String[] rfcArray = new String[cantidadRFCs]; 
            int cantidadNumeros = 100;
            int[] numeros = new int[cantidadNumeros];
            // Generar nombres aleatorios y llenar el vector
            for (int i = 0; i < nombres.length; i++) {
                nombres[i] = generarNombreAleatorio();
            }   
            
            // Generar apellidos aleatorios y llenar el vector    
            for (int i = 0; i < apellidos.length; i++) {
                apellidos[i] = generarApellidoAleatorio();
            }  
            
            // Generar números de teléfono aleatorios y llenar el vector
            for (int i = 0; i < numerosTelefono.length; i++) {
                numerosTelefono[i] = generarNumeroTelefonoAleatorio();
            } 

            // Generar correos electrónicos aleatorios y llenar el vector
            for (int i = 0; i < correosElectronicos.length; i++) {
                correosElectronicos[i] = generarCorreoElectronicoAleatorio();
            } 
            
            // Generar puestos de trabajo aleatorios y llenar el vector
            for (int i = 0; i < puestosTrabajo.length; i++) {
                puestosTrabajo[i] = generarPuestoTrabajoAleatorio();
            }  
            
            // Generar sueldos aleatorios y llenar el vector
            for (int i = 0; i < sueldos.length; i++) {
                sueldos[i] = generarSueldoAleatorio();
            }   
            
            // Generar RFCs aleatorios y llenar el vector
            for (int i = 0; i < cantidadRFCs; i++) {
                rfcArray[i] = generarRFC();
            }            
            
            // Generar números aleatorios de 5 dígitos y llenar el vector
            for (int i = 0; i < cantidadNumeros; i++) {
                numeros[i] = generarNumero5Digitos();
            }            
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Preparar la sentencia SQL para insertar registros
            String sql = "insert into empleado(id_persona,id_direccion,nombre,apellido_paterno,apellido_materno,num_telefono,correo,rfc,id_empleado,id_departamento,sueldo,puesto) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Insertar 1,000,000 de registros de empleados
            int id_persona = 32;
            int id_direccion =111;
            for (int i = 0; i <= 100; i++) {
                id_persona = id_persona + 1;
                id_direccion = id_direccion +1;
                statement.setInt(1, id_persona );
                statement.setInt(2, id_direccion );
                statement.setString(3, "Nombre" + i);
                statement.setString(4, "Apellido" + i);
                statement.setString(5, "Paterno" + i);
                statement.setString(6, "ApellidoMaterno" + i);
                statement.setString(7, "Telefono" + i);
                statement.setString(8, "correo" + i + "@gmail.com");
                statement.setString(7, "RFC" + i);
                statement.setString(8, "Estado" + i);
                statement.setString(9, "Municipio" + i);
                statement.setString(10, "CodigoPostal" + i);
                statement.setString(11, "NumeroExterior" + i);
                statement.setString(12, "Puesto" + i);
                statement.setDouble(13, 5000.0); // Sueldo fijo para todos los empleados
                statement.setInt(14, 1234);
                
                statement.executeUpdate();
            }
            
            System.out.println("Registros de empleados insertados exitosamente.");
            
            // Cerrar la conexión y liberar recursos
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar registros de empleados: " + e.getMessage());
        }
    }
    
    // Método para generar nombres aleatorios
    public static String generarNombreAleatorio() {
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía", "Javier", "Isabella", "Alejandro", "Valentina", "Miguel", "Camila", "Andrés", "Lucía", "Fernando", "Daniela", "Gabriel", "Elena", "Diego", "Claudia", "Ricardo", "Mariana", "José", "Gabriela", "Raul", "Paula", "Arturo", "Victoria"};
        Random random = new Random();
        int indice = random.nextInt(nombres.length);
        return nombres[indice];
    }

    
    // Método para generar apellidos aleatorios
    public static String generarApellidoAleatorio() {
        String[] apellidos = {"García", "Hernández", "López", "Martínez", "González", "Rodríguez", "Pérez", "Sánchez", "Ramírez", "Torres", "Flores", "Rivera", "Ortiz", "Cruz", "Díaz", "Reyes", "Morales", "Castillo", "Jiménez", "Rojas", "Silva", "Romero", "Vargas", "Mendoza", "Guerrero", "Delgado", "Navarro", "Cortés", "Ramos", "Mendoza"};
        Random random = new Random();
        int indice = random.nextInt(apellidos.length);
        return apellidos[indice];
    }

    // Método para generar números de teléfono aleatorios
    public static String generarNumeroTelefonoAleatorio() {
        Random random = new Random();
        StringBuilder numeroTelefono = new StringBuilder();
        
        // Generar código de país (ejemplo: +52 para México)
        numeroTelefono.append("+52");
        
        // Generar código de área (ejemplo: 55 para Ciudad de México)
        numeroTelefono.append("55");
        
        // Generar dígitos restantes (8 dígitos)
        for (int i = 0; i < 8; i++) {
            int digito = random.nextInt(10);
            numeroTelefono.append(digito);
        }
        
        return numeroTelefono.toString();
    }
    
    // Método para generar correos electrónicos aleatorios
    public static String generarCorreoElectronicoAleatorio() {
        String[] nombres = {"juan", "maria", "pedro", "ana", "luis", "laura", "carlos", "sofia", "javier", "isabella", "alejandro", "valentina", "miguel", "camila", "andres", "lucia", "fernando", "daniela", "gabriel", "elena"};
        String[] dominios = {"gmail.com", "hotmail.com", "outlook.com", "yahoo.com", "live.com"};
        Random random = new Random();
        
        // Generar un nombre aleatorio
        int indiceNombre = random.nextInt(nombres.length);
        String nombre = nombres[indiceNombre];
        
        // Generar un número aleatorio para el correo electrónico
        int numero = random.nextInt(10000);
        
        // Generar un dominio aleatorio
        int indiceDominio = random.nextInt(dominios.length);
        String dominio = dominios[indiceDominio];
        
        // Combinar el nombre, número y dominio para formar el correo electrónico
        String correoElectronico = nombre + numero + "@" + dominio;
        
        return correoElectronico;
    }
    
    // Método para generar puestos de trabajo aleatorios
    public static String generarPuestoTrabajoAleatorio() {
        String[] puestos = {"Gerente", "Analista", "Desarrollador", "Diseñador", "Contador", "Administrativo", "Ventas", "Recursos Humanos", "Ingeniero", "Ejecutivo de Cuentas", "Asistente Administrativo", "Marketing", "Consultor", "Operario", "Supervisor", "Jefe de Proyecto", "Coordinador", "Abogado", "Técnico", "Investigador"};
        Random random = new Random();
        int indice = random.nextInt(puestos.length);
        return puestos[indice];
    }  

    // Método para generar sueldos aleatorios
    public static double generarSueldoAleatorio() {
        double sueldoMinimo = 1000.0;
        double sueldoMaximo = 5000.0;
        
        Random random = new Random();
        double sueldo = sueldoMinimo + (sueldoMaximo - sueldoMinimo) * random.nextDouble();
        return sueldo;
    }
    

    // Método para generar un RFC aleatorio
    public static String generarRFC() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder rfcBuilder = new StringBuilder();

        Random random = new Random();

        // Generar tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(letras.length());
            rfcBuilder.append(letras.charAt(indice));
        }

        // Generar seis dígitos aleatorios
        for (int i = 0; i < 6; i++) {
            int digito = random.nextInt(10);
            rfcBuilder.append(digito);
        }

        // Generar homoclave de tres caracteres aleatorios
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(letras.length());
            rfcBuilder.append(letras.charAt(indice));
        }

        return rfcBuilder.toString();
    }   

    // Método para generar un número aleatorio de 5 dígitos
    public static int generarNumero5Digitos() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
  
}


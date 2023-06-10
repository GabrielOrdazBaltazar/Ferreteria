package vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import paquete1.EmpleadoSQL;

public class Ferreteria2 {
public static void main(String[] args) {
        
        ingresar1000000Empleado();
        
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
        numeroTelefono.append("");
        
        // Generar código de área (ejemplo: 55 para Ciudad de México)
        numeroTelefono.append("");
        
        // Generar dígitos restantes (8 dígitos)
        for (int i = 0; i < 5; i++) {
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
    
    public static void ingresar1000000Empleado() {
        //Variables locales
        String[] nombres = new String[100];
        String[] apellidos = new String[100];
        String[] numerosTelefono = new String[100];
        String[] correosElectronicos = new String[100];
        String[] puestosTrabajo = new String[100]; 
        double[] sueldos = new double[100];
        int cantidadRFCs = 1000000;
        String[] rfcArray = new String[cantidadRFCs]; 
        String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche","Coahuila", "Colima", "Chiapas", "Chihuahua", "Ciudad de México", "Durango","Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán","Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro","Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco","Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};       
        String[] municipios = {"Aguascalientes", "Asientos", "Calvillo", "Cosío", "Jesús María","Pabellón de Arteaga", "Rincón de Romos", "San Francisco de los Romo","San José de Gracia", "Tepezalá"};        
        int cantidadNumeros = 100;
        int[] numeros = new int[cantidadNumeros];        
        int[] departamento = {1234,1235};
        
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
            
            int contadorEst = 0;
            int contadorMun = 0;
            int contadorRFC = 0;
            int contadorDep = 0;
            int id_empleado =  215078;
            
            String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ferreteria";
            try (Connection conn = DriverManager.getConnection(url, "postgres", "12345")) {
                // Crear una tabla para los empleados si no existe
                String sql = "CREATE TABLE IF NOT EXISTS Empleados (\n"
                        + "	id_empleado integer PRIMARY KEY,\n"
                        + "	nombre text NOT NULL,\n"
                        + "	apellidos text NOT NULL,\n"
                        + "	telefono integer NOT NULL,\n"
                        + "	correo text NOT NULL,\n"
                        + "	RFC text NOT NULL,\n"
                        + "	puesto text NOT NULL,\n"
                        + "	sueldo double NOT NULL,\n"
                        + "	id_departamento integer NOT NULL,\n"
                        + ");";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(sql);
                } 
                
             // Insertar los datos de los empleados en la tabla
                sql = "INSERT INTO Empleados(id_empleado, nombre, apellidos, telefono, correo, RFC, puesto, sueldo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    for (int i = 0; i < 100; i++) {
                        for (int j = 0; j < 100; j++) {
                            // Generar los datos de los empleados aquí...

                            // Establecer los valores para la inserción
                            pstmt.setInt(1, id_empleado);
                            pstmt.setString(2, nombres[j]);
                            pstmt.setString(3, apellidos[i]);
                            pstmt.setString(4, numerosTelefono[i]);
                            pstmt.setString(5, correosElectronicos[i]);
                            pstmt.setString(6, rfcArray[i]);
                            pstmt.setString(7, puestosTrabajo[i]);
                            pstmt.setDouble(8, sueldos[i]); 

                            pstmt.executeUpdate();

                            id_empleado = id_empleado + 1;
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
                
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    paquete1.Direccion direccion = new paquete1.Direccion(estados[contadorEst], municipios[contadorMun],numeros[j], String.valueOf(numeros[j]));
                    
                    paquete1.DepartamentoSQL dep = new paquete1.DepartamentoSQL();
                    paquete1.Departamento dep1 = new paquete1.Departamento();
                    
                    contadorEst++;
                    contadorMun++;
                    contadorRFC++;
                    if(contadorEst == estados.length){
                        contadorEst = 0;
                    }
                    if(contadorMun == municipios.length){
                        contadorMun = 0;
                    }
                    dep1 = dep.buscarDepartamento(departamento[contadorDep]);
                    paquete1.Empleado emp = new paquete1.Empleado(direccion, nombres[j], apellidos[i], apellidos[99-j], Integer.parseInt(numerosTelefono[j]),correosElectronicos[j], rfcArray[j],id_empleado,dep1 , sueldos[j],puestosTrabajo[j]);                    
                    id_empleado = id_empleado + 1;
                    contadorDep ++;
                    if(contadorDep == 2){
                        contadorDep = 0;
                    }
                }
            }  
    }        
}

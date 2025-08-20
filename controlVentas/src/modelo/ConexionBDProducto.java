
package modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class ConexionBDProducto {
    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String BD = "ventas";
    private final String USER = "postgres";
    private final String PASSWORD = "12345";
    
    public Connection conexion;
    public Statement stmt;
    
    public ConexionBDProducto(){
    }
    
    public Connection getConexion(){
        stmt = null;
        conexion = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + HOST +":"+ PUERTO+ "/"+BD;
            conexion = DriverManager.getConnection(url, USER,PASSWORD);
            stmt = conexion.createStatement();
            System.out.println("Conexion exitosa...");
            
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
            
        }
        return conexion;
    }
    
    
}

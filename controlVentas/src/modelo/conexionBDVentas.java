/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class conexionBDVentas {
    String user="postgres";
        String password="12345";
        String dataBase="ventas";
        String id="localhost";
        String port="5432";
        String url = "jdbc:postgresql://"+id+":"+port+"/"+dataBase;
        
        public static conexionBDVentas instancia = null;
        Connection conexion = null;
        
        public conexionBDVentas(){
             try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        }
        
        public  static conexionBDVentas getInstance(){
            if (instancia == null) {
            synchronized (conexionBDVentas.class) {
                if (instancia == null) {
                    instancia = new conexionBDVentas();
                }
            }
        }
        return instancia;
        }
        
        public  Connection getConexion(){
            return conexion;
        }
        
        
       
    
    public void cerrarConexion() throws SQLException{
        if(conexion != null){
            conexion.close();
            conexion = null;
            instancia = null;
            System.out.println("conexion Cerrada");
        }
    }
}

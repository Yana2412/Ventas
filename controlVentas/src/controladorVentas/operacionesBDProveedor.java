/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.conexionBDVentas;
import modelo.crudProveedor;

/**
 *
 * @author valer
 */
public class operacionesBDProveedor extends crudProveedor {
    
    
    conexionBDVentas objConexion;
    DefaultTableModel tablaModelo;
    
    public operacionesBDProveedor(){
        objConexion = conexionBDVentas.getInstance();
    }

    @Override
    public void create(String nombre,int telefono, String direccion) {
         String sql = "SELECT insertProveedor(?, ?, ?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, telefono);
            ps.setString(3, direccion);
            ps.execute();
            
            System.out.println("FUNCION INSERTPROVEEDOR EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a insertProveedor: " + e.getMessage());
        }
    }

    @Override
    public void read() {
       String[] columnas = { "IDPROVEEDOR","NOMBRE","TELEFONO","DIRECCION"};
        
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
        
        String sql = "select * from consultarProveedor()";
        try {
            PreparedStatement stm = objConexion.getConexion().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Object[] filas = new Object[]{
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("tel"),
                    rs.getString("direccion"),
                };
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.getLogger(operacionesBDVentas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         this.tablaModelo = modelo;
    }

    @Override
    public void update(String nombre,int telefono,String direccion,int idProveedor) {
        String sql = "SELECT updateProveedor(?, ?, ?, ?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, telefono);
            ps.setString(3, direccion);
            ps.setInt(4, idProveedor);
            ps.execute();
            
            System.out.println("FUNCION ACTUALIZACION EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a updateProveedor: " + e.getMessage());
        }
    }

    @Override
    public void delete(int idProveedor) {
        String sql = "SELECT deleteProveedor(?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ps.execute();
            
            System.out.println("FUNCION ELIMINAR EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a deleteProveedor: " + e.getMessage());
        }
    }

    public DefaultTableModel getModelo() {
        return tablaModelo;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import modelo.CRUDProducto;
import vistasVentas.VistaProducto;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBDProducto;
import modelo.ConexionBDProducto;
import modelo.ConexionBDProducto;
import modelo.ConexionBDProducto;
/**
 *
 * @author valer
 */
public class OperacionesBDProducto extends CRUDProducto{
    private Statement t;
    VistaProducto objVista = new VistaProducto();
    DefaultTableModel tablaModelo;
    ConexionBDProducto objConex = new ConexionBDProducto();

    
    @Override
    public void create(int idProveedor, String producto, int precio) {
        String sql = "Select insertProducto(?,?,?)";
        try (PreparedStatement ps = objConex.getConexion().prepareStatement(sql)){
            ps.setInt(1, idProveedor);
            ps.setString(2, producto);
            ps.setInt(3, precio);
            ps.execute();
            
            System.out.println("insertar producto ejecutada...");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar producto: "+e.getMessage());
        }
    }

    
    @Override
    public void read() {
        String[] columnas = { "id_producto","fk_proveedor","producto","precio"};
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
       
        String sql = "select * from consultarProducto()";
        try {
            PreparedStatement ps = objConex.getConexion().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Object[] filas = new Object[]{
                    rs.getInt("id_producto"),
                    rs.getInt("fk_proveedor"),
                    rs.getString("producto"),
                    rs.getInt("precio")
                };
                modelo.addRow(filas);
                        
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer productos: "+e.getMessage());
        }
        this.tablaModelo= modelo;
    }

    
    @Override
    public void update(int idProducto, int idProveedor, String producto, int precio) {
        String sql = "select updateProducto(?,?,?,?)";
        try (PreparedStatement ps = objConex.getConexion().prepareStatement(sql)){
            ps.setInt(1, idProducto);
            ps.setInt(2, idProveedor);
            ps.setString(3, producto);
            ps.setInt(4, precio);
            ps.execute();
            System.out.println("actualizacion exitosa...");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de actuaizacion: "+e.getMessage());
        }
    }

    
    @Override
    public void delete(int idproducto) {
        String sql = "select deleteProducto(?)";
        
        try (PreparedStatement ps = objConex.getConexion().prepareStatement(sql)){
            ps.setInt(1, idproducto);
            ps.execute();
            System.out.println("Eliminacion exitosa...");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de eliminacion: "+e.getMessage());
        }
    }
    
}

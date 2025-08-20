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
import modelo.crudVentas;

/**
 *
 * @author julio
 */
public class operacionesBDVentas extends crudVentas {

    public final conexionBDVentas objConexion;
    
    DefaultTableModel tablaModelo;

    public operacionesBDVentas() {
        objConexion = conexionBDVentas.getInstance();
        
    }

    @Override
    public void create(int idCliente, int total, String fecha) {
        String sql = "SELECT insertVentas(?, ?, ?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.setInt(2, total);
            ps.setString(3, fecha);
            ps.execute();
            
            System.out.println("FUNCION INSERTUSUARIO EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a insertVentas: " + e.getMessage());
        }

    }

    @Override
    public void read() {
        
        String[] columnas = { "IDVENTA","IDCLIENTE","TOTAL","FECHA"};
        
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
        
        String sql = "select * from consultarVentas() as ventas(idventa int,idcliente int,total int,fecha text)";
        try {
            PreparedStatement stm = objConexion.getConexion().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Object[] filas = new Object[]{
                    rs.getInt("idventa"),
                    rs.getInt("idcliente"),
                    rs.getInt("total"),
                    rs.getString("fecha"),
                };
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.getLogger(operacionesBDVentas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         this.tablaModelo = modelo;
    }

    @Override
    public void update(int idCliente, int total, String fecha,int idVenta) {
       String sql = "SELECT updateVentas(?, ?, ?, ?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.setInt(2, total);
            ps.setString(3, fecha);
            ps.setInt(4, idVenta);
            ps.execute();
            
            System.out.println("FUNCION ACTUALIZACION EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a updateVentas: " + e.getMessage());
        }
    }

    @Override
    public void delete(int idVenta) {
         String sql = "SELECT deleteVentas(?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            ps.execute();
            
            System.out.println("FUNCION ELIMINAR EJECUTADA  ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llamar a deleteVentas: " + e.getMessage());
        }
    }

    public void reatDetalle(){
         String[] columnas = { "IDDETALLE","IDVENTA","IDPRODUCTO","CANTPRODUCTO","SUBTOTAL"};
        
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
        
        String sql = "select * from consultarDVentas() as ventas(iddetalle int,idventa int,idproducto int,cantproducto int,subtotal int)";
        try {
            PreparedStatement stm = objConexion.getConexion().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Object[] filas = new Object[]{
                    rs.getInt("iddetalle"),
                    rs.getInt("idventa"),
                    rs.getInt("idproducto"),
                    rs.getInt("cantproducto"),
                    rs.getInt("subtotal"),
                };
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.getLogger(operacionesBDVentas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         this.tablaModelo = modelo;
    }
    public DefaultTableModel getTablaModelo() {
        return tablaModelo;
    }

    
}

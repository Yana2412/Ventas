/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import modelo.crudCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.conexionBDVentas;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OperacionesBdCliente extends crudCliente{
    conexionBDVentas objConexion;
    DefaultTableModel tablaModelo;

    public OperacionesBdCliente(){
        objConexion = conexionBDVentas.getInstance();
    }
    
    @Override
    public void create(String nombre, int telefono, String direccion) {
        String sql = "select insertCliente(?,?,?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql) ){
            ps.setString(1, nombre);
            ps.setInt(2, telefono);
            ps.setString(3, direccion);
            ps.execute();
            System.out.println("Se inserto correctamente en la bd...");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: "+e.getMessage());
        }
    }

    @Override
    public void read() {
        String[] columnas={"IDCLIENTE","NOMBRE","TELEFONO","DIRECCION"};
        DefaultTableModel modelo = new DefaultTableModel(null,columnas);
        String sql = "select  * from consultarClientes()";
        try{ 
            PreparedStatement ps = objConexion.getConexion().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Object[] filas = new Object[]{
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs.getString("direccion")
                };
                modelo.addRow(filas);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conculta sql: "+e.getMessage());    
        }
        this.tablaModelo = modelo;
    }

    @Override
    public void update(int idcliente, String nombre, int telefono, String direccion) {
        String sql = "Select updateCliente(?,?,?,?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)){
            ps.setString(1,nombre);
            ps.setInt(2, telefono);
            ps.setString(3, direccion);
            ps.setInt(4, idcliente);
            ps.execute();
            System.out.println("actualizacion exitosa...");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar: "+e.getMessage());
        }
    }

    @Override
    public void delete(int idCliente) {
        String sql = "Select deletecliente(?)";
        try (PreparedStatement ps = objConexion.getConexion().prepareStatement(sql)){
            ps.setInt(1, idCliente);
            ps.execute();
            System.out.println("Eliminacion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error de eliminacion Sql: "+e.getMessage());
        }
    }

    public DefaultTableModel getTablaModelo() {
        return tablaModelo;
    }
    
    
}

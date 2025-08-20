/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistasVentas.viewMain;
import vistasVentas.vistaProveedor;

/**
 *
 * @author valer
 */
public class controlProveedor implements ActionListener{

    vistaProveedor objVista;
    operacionesBDProveedor objOpera;
    public controlProveedor(vistaProveedor objVista){
        this.objVista = objVista;
        objOpera = new operacionesBDProveedor();
        
        this.objVista.btnCreate.addActionListener(this);
        this.objVista.btnConsulta.addActionListener(this);
        this.objVista.btnActualizar.addActionListener(this);
        this.objVista.btnEliminar.addActionListener(this);
        this.objVista.btnBack.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == objVista.btnCreate){
           String nombre = objVista.txtNombre.getText();
           int telefono = Integer.parseInt(objVista.txtTelefono.getText());
           String direccion = objVista.txtDireccion.getText();
           
           objOpera.create(nombre, telefono, direccion);
       }
       if(e.getSource() == objVista.btnConsulta){
           objOpera.read();
           objVista.tblProveedor.setModel(objOpera.getModelo());
       }
       if(e.getSource() == objVista.btnActualizar){
           //String nombre = objVista.txtNombre.getText();
           //String telefono = objVista.txtTelefono.getText();
           //String direccion = objVista.txtDireccion.getText();
           
           String idEntrada = JOptionPane.showInputDialog(null, "Escribe la id a actualizar");
           if(idEntrada != null && !idEntrada.trim().isEmpty()){
               int idProveedor = Integer.parseInt(idEntrada);
               String nombre = objVista.txtNombre.getText().trim();
               int telefono = Integer.parseInt(objVista.txtTelefono.getText().trim());
               String direccion = objVista.txtDireccion.getText().trim();
               operacionesBDProveedor op = new operacionesBDProveedor();
               op.update(nombre, telefono, direccion, idProveedor);
               System.out.println("Proveedor actualizado");
           }else{
               JOptionPane.showMessageDialog(null, "Error, debe ingresar los campos.");
           }    
       }
       
       
       if(e.getSource() == objVista.btnEliminar){
           String idDel = JOptionPane.showInputDialog(null, "Escribe la id a elimianr");
           if(idDel != null && !idDel.trim().isEmpty()){
               int id = Integer.parseInt(idDel);
               operacionesBDProveedor op = new operacionesBDProveedor();
               op.delete(id);
               System.out.println("Datos eliminados correctamente.");
           }else{
                JOptionPane.showMessageDialog(null, "Error, debe ingresar los campos.");
           }
           
       }
       if(e.getSource() == objVista.btnBack){
           viewMain objMain = new viewMain();
           objVista.setVisible(false);
           objMain.setVisible(true);
       }
    }
    
}

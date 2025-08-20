/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.VistaCliente;
import vistasVentas.VistaProducto;
import vistasVentas.crudVentas;
import vistasVentas.viewMain;
import vistasVentas.vistaProveedor;

/**
 *
 * @author julio
 */
public class controlMain implements ActionListener{

    viewMain objView;
    crudVentas objVentas;
    VistaProducto objProd;
    VistaCliente objCliente;
    vistaProveedor objProv;
    public controlMain(viewMain objView){
        this.objView= objView;
        objVentas = new crudVentas();
        objProd = new VistaProducto();
        objCliente = new VistaCliente();
        objProv = new vistaProveedor();
        
        
        this.objView.btnVentas.addActionListener(this);
        this.objView.btnProductos.addActionListener(this);
        this.objView.btnCliente.addActionListener(this);
        this.objView.btnProveedor.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == objView.btnVentas){
             objView.setVisible(false);
             objVentas.setVisible(true);
        }
        if (ae.getSource() == objView.btnProductos){
             objView.setVisible(false);
             objProd.setVisible(true);
        }
        
        if (ae.getSource() == objView.btnCliente){
             objView.setVisible(false);
             objCliente.setVisible(true);
        }
        if (ae.getSource() == objView.btnProveedor){
             objView.setVisible(false);
             objProv.setVisible(true);
        }
        
    }
    
}

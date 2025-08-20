/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.crudVentas;
import vistasVentas.updateVentas;

/**
 *
 * @author julio
 */
public class controlUpdateVentas implements ActionListener{

    updateVentas objUpdate;
    crudVentas objVentas;
    public controlUpdateVentas(updateVentas objUpdate){
        this.objUpdate=objUpdate;
        objVentas = new crudVentas();
        
        this.objUpdate.btnBack.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objUpdate.btnBack){
            int idCliente = Integer.parseInt(objUpdate.txtIDcliente.getText());
            int total = Integer.parseInt(objUpdate.txtTotal.getText());
            String fecha = objUpdate.txtFecha.getText();
            int idVenta = Integer.parseInt(objUpdate.txtIDventa.getText());
            
            operacionesBDVentas ops = new operacionesBDVentas();
            ops.update(idCliente, total, fecha, idVenta);
            
            objUpdate.setVisible(false);
            objVentas.setVisible(true);
            
        }
    }
    
}

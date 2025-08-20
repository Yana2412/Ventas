/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.crudVentas;
import vistasVentas.detalleView;

/**
 *
 * @author julio
 */
public class controlDetallev implements ActionListener{
    detalleView objDetalle;
    crudVentas objVentas;
    public controlDetallev(detalleView objDetalle){
        this.objDetalle=objDetalle;
        objVentas = new crudVentas();
        
        this.objDetalle.btnBack.addActionListener(this);
        this.objDetalle.btnDetalle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objDetalle.btnBack){
            
            objDetalle.setVisible(false);
            objVentas.setVisible(true);
        }
        if(ae.getSource() == objDetalle.btnDetalle){
            operacionesBDVentas ops = new operacionesBDVentas();
            ops.reatDetalle();
            objDetalle.tblDetalle.setModel(ops.getTablaModelo());
        }
    }
}

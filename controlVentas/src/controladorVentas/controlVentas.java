/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.createVentas;
import vistasVentas.crudVentas;
import vistasVentas.deleteVentas;
import vistasVentas.detalleView;
import vistasVentas.readVentas;
import vistasVentas.updateVentas;
import vistasVentas.viewMain;

/**
 *
 * @author julio
 */
public class controlVentas implements ActionListener {
    crudVentas objVentas;
    viewMain objMain;
    createVentas objCreate;
    readVentas objRead;
    updateVentas objUpdate;
    deleteVentas objDelete;
    detalleView objDetalle;
    
    public controlVentas( crudVentas objVentas){
        this.objVentas = objVentas;
        
        this.objVentas.btnCreate.addActionListener(this);
        this.objVentas.btnRead.addActionListener(this);
        this.objVentas.btnUpdate.addActionListener(this);
        this.objVentas.btnDelete.addActionListener(this);
        this.objVentas.btnBack.addActionListener(this);
        this.objVentas.btnDetalle.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objVentas.btnBack){
            objMain = new viewMain();
            objVentas.setVisible(false);
            objMain.setVisible(true);
        }
        if(ae.getSource() == objVentas.btnCreate){
            objCreate = new createVentas();
            objVentas.setVisible(false);
            objCreate.setVisible(true);
        }
        if(ae.getSource() == objVentas.btnRead){
            objRead = new readVentas();
            objVentas.setVisible(false);
            objRead.setVisible(true);
        }
        if(ae.getSource() == objVentas.btnUpdate){
            objUpdate = new updateVentas();
            objVentas.setVisible(false);
            objUpdate.setVisible(true);
        }
        if(ae.getSource() == objVentas.btnDelete){
            objDelete = new deleteVentas();
            objVentas.setVisible(false);
            objDelete.setVisible(true);
        }
        if(ae.getSource() == objVentas.btnDetalle){
            objDetalle = new detalleView();
            objVentas.setVisible(false);
            objDetalle.setVisible(true);
        }
    }
    
}

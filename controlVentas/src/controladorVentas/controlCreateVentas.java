/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.createVentas;
import vistasVentas.crudVentas;

/**
 *
 * @author julio
 */
public class controlCreateVentas implements ActionListener{
    createVentas objCreate;
    crudVentas objVentas;
    public controlCreateVentas(createVentas objCreate){
        this.objCreate=objCreate;
        objVentas = new crudVentas();
        
        
        this.objCreate.btnBack.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objCreate.btnCreate){
            
            int Id = Integer.parseInt(objCreate.txtID.getText());
            int Total = Integer.parseInt(objCreate.txtcliente.getText());
            String Fecha = objCreate.txtFecha.getText();
            operacionesBDVentas ops = new operacionesBDVentas();
            ops.create(Id, Total, Fecha);
            
        }
        if(ae.getSource() == objCreate.btnBack){
            
            objCreate.setVisible(false);
            objVentas.setVisible(true);
        }
        
    }
    
}

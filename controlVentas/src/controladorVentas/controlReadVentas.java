/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.crudVentas;
import vistasVentas.readVentas;

/**
 *
 * @author julio
 */
public class controlReadVentas implements ActionListener{
    readVentas objRead;
    crudVentas objVentas;
    
    
    public controlReadVentas(readVentas objRead){
        this.objRead=objRead;
        objVentas = new crudVentas();
         
        this.objRead.btnBack.addActionListener(this);
        this.objRead.btnVentas.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objRead.btnBack){
             
            objRead.setVisible(false);
            objVentas.setVisible(true);
        }
        if(ae.getSource() == objRead.btnVentas){
             operacionesBDVentas ops = new operacionesBDVentas();
             ops.read();
             objRead.tblVentas.setModel(ops.getTablaModelo());
                     
        }
    }
    
}

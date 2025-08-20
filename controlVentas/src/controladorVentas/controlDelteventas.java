/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistasVentas.crudVentas;
import vistasVentas.deleteVentas;

/**
 *
 * @author julio
 */
public class controlDelteventas implements ActionListener{

    deleteVentas objDelete;
    crudVentas objVentas;
    public controlDelteventas(deleteVentas objDelete){
        this.objDelete=objDelete;
        objVentas = new crudVentas();
        
        this.objDelete.btnContinuar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == objDelete.btnContinuar){
            
            int IDventa = Integer.parseInt(objDelete.txtIDventa.getText());
            
            operacionesBDVentas ops = new operacionesBDVentas();
            ops.delete(IDventa);
            
            objDelete.setVisible(false);
            objVentas.setVisible(true);
        }
    }
    
}

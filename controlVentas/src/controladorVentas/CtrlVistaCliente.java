/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistasVentas.VistaCliente;
import vistasVentas.viewMain;


public class CtrlVistaCliente implements ActionListener{
    VistaCliente objVistaC;
    
    
    public CtrlVistaCliente(VistaCliente vistaC){
        this.objVistaC = vistaC;
        
        
        this.objVistaC.btnRegistrar.addActionListener(this);
        this.objVistaC.btnConsult.addActionListener(this);
        this.objVistaC.btnActualizar.addActionListener(this);
        this.objVistaC.btnEliminar.addActionListener(this);
        this.objVistaC.btnBack.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == objVistaC.btnBack){
            viewMain objMain = new viewMain();
            objVistaC.setVisible(false);
            objMain.setVisible(true);
        }
        if(e.getSource() == objVistaC.btnRegistrar){
            String _nombre = objVistaC.txtNombre.getText();
            int _telefono = Integer.parseInt(objVistaC.txtTelefono.getText());
            String _direccion = objVistaC.txtDireccion.getText();
            
            OperacionesBdCliente op = new OperacionesBdCliente();
            op.create(_nombre, _telefono, _direccion);
        }
        
        if (e.getSource()== objVistaC.btnConsult){
            OperacionesBdCliente op = new OperacionesBdCliente();
            op.read();
            objVistaC.table.setModel(op.getTablaModelo());
        }
        
        if(e.getSource()==objVistaC.btnActualizar){
            int id = Integer.parseInt(objVistaC.txtIDCliente.getText().trim());
            String nombre = objVistaC.txtNombre.getText().trim();
            int telefono = Integer.parseInt(objVistaC.txtTelefono.getText().trim());
            String direccion = objVistaC.txtDireccion.getText().trim();
            
            OperacionesBdCliente op = new OperacionesBdCliente();
            op.update(id, nombre, telefono, direccion);
        }
        
        if (e.getSource()== objVistaC.btnEliminar){
            int idCliente = Integer.parseInt(objVistaC.txtIDCliente.getText().trim());
            OperacionesBdCliente op = new OperacionesBdCliente();
            op.delete(idCliente);
        }
        
    }
    
}

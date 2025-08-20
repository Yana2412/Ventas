package controladorVentas;

import controladorVentas.OperacionesBDProducto;
import vistasVentas.VistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistasVentas.viewMain;

public class CtrlVistaProducto implements ActionListener {

    VistaProducto objVista;

    public CtrlVistaProducto(VistaProducto vista) {
        this.objVista = vista;
        this.objVista.btnAgregar.addActionListener(this);
        this.objVista.btnActualizar.addActionListener(this);
        this.objVista.btnEliminar.addActionListener(this);
        this.objVista.btnLeer.addActionListener(this);
        this.objVista.btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objVista.btnAgregar) {
            int idProveedor = Integer.parseInt(objVista.txtIdProvee.getText());
            String producto = objVista.txtProducto.getText();
            int precio = Integer.parseInt(objVista.txtPrecio.getText());
            OperacionesBDProducto opBd = new OperacionesBDProducto();
            opBd.create(idProveedor, producto, precio);

            objVista.setVisible(true);
        }
        
        
        if(e.getSource() ==objVista.btnActualizar){
            String idStg = JOptionPane.showInputDialog(null, "Ingrese la id a actualizar:");
            if (idStg != null && !idStg.trim().isEmpty()) {
                int idProducto = Integer.parseInt(idStg);
                int idProveedor = Integer.parseInt(objVista.txtIdProvee.getText().trim());
                String producto = objVista.txtProducto.getText().trim();
                int precio = Integer.parseInt(objVista.txtPrecio.getText().trim());
                
                OperacionesBDProducto op = new OperacionesBDProducto();
                op.update(idProducto, idProveedor, producto, precio);
                
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "debe ingresar campos ");
            }
        }
        

        if (e.getSource() == objVista.btnLeer) {
            OperacionesBDProducto op = new OperacionesBDProducto();
            op.read();
            objVista.TableConsulta.setModel(op.tablaModelo);
        }
        

        if (e.getSource() == objVista.btnEliminar) {
            String idSt = JOptionPane.showInputDialog(null, "Ingrese la id a eliminar:");
            if (idSt != null && !idSt.trim().isEmpty()) {

                int idproducto = Integer.parseInt(idSt);
                OperacionesBDProducto op = new OperacionesBDProducto();
                op.delete(idproducto);
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "ingrese un valor");
            }

        }
        if(e.getSource() == objVista.btnBack){
            viewMain objMain = new viewMain();
            objVista.setVisible(false);
            objMain.setVisible(true);
        }

    }

}

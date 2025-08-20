/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vistasVentas;

import controladorVentas.CtrlVistaProducto;
import vistasVentas.VistaProducto;

/**
 *
 * @author valer
 */
public class Ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaProducto vista = new VistaProducto();
        CtrlVistaProducto ctrl = new CtrlVistaProducto(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}

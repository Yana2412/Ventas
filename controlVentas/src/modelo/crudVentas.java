/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author julio
 */
public abstract class crudVentas {
    
    public abstract void create(int idCliente, int total, String fecha);
    public abstract void read();
    public abstract void update(int idCliente, int total, String fecha,int idVenta);
    public abstract void delete(int idVenta);
    
}

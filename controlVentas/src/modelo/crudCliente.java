/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author valer
 */
public abstract class crudCliente {
    public abstract void create (String nombre, int telefono, String direccion);
    public abstract void read ();
    public abstract void update(int idcliente, String nombre, int telefono,String direccion);
    public abstract void delete (int idCliente);
    
}

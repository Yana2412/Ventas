/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Producto {
    private int idProducto,fkProveedor, precio;
    private String descripcionProducto;
    public Producto(){
    }

    public Producto(int idProducto, int fkProveedor, int precio, String descripcionProducto) {
        this.idProducto = idProducto;
        this.fkProveedor = fkProveedor;
        this.precio = precio;
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getFkProveedor() {
        return fkProveedor;
    }

    public void setFkProveedor(int fkProveedor) {
        this.fkProveedor = fkProveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
    
}

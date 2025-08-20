
package modelo;


public abstract class CRUDProducto {
    public abstract void create(int idProveedor,String producto, int precio);
    public abstract void read();
    public abstract void  update(int idProducto, int idProveedor, String producto, int precio);
    public abstract void delete(int idproducto);
 
}

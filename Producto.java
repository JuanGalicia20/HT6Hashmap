
/**
 * @author Juan Galicia 20298
 * @author Jonathan Espinoza 20022
 */
public class Producto {
    private String categoria;
    private int cantidad = 0;

    /**
     * Constructor
     * @param categoria categoria del producto
     * @param cantidad cantidad del producto
     */
    public Producto(String categoria, int cantidad){
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    /**
     * Constructor secundario
     * @param cateogria categoria del producto
     */
    public Producto(String cateogria){
        this.categoria = categoria;
        cantidad++;
    }

    
    /** 
     * @return String
     */
    public String getCategoria(){
        return categoria;
    }

    
    /** 
     * @return int
     */
    public int getCantidad(){
        return cantidad;
    }

    
    /** 
     * @param cantidad
     */
    public void setCantidad(int cantidad){
        this.cantidad += cantidad;
    }

    
    /** 
     * Metodo que imprime las caracteristicas del objeto
     * @param name llave principal que es el nombre del articulo
     * @return String cadena de texto
     */
    public String toString(String name){
        return  "Nombre: " + name + "\nCategoria: " + this.categoria + "\nCantidad: " + this.cantidad;
    }

}

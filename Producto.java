public class Producto {
    private String categoria;
    private int cantidad = 0;

    public Producto(String categoria, int cantidad){
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public Producto(String cateogria){
        this.categoria = categoria;
        cantidad++;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad += cantidad;
    }

    public String toString(String name){
        return  "Nombre: " + name + "\nCategoria: " + this.categoria + "\nCantidad: " + this.cantidad;
    }

}

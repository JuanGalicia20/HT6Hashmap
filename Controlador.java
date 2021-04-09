import java.util.ArrayList;
import java.util.Map;

public class Controlador {

Map<String, Producto> inventario;
Map<String, Producto> coleccionUsuario;
    
     public Controlador(Map<String, Producto> inventario, Map<String, Producto> coleccionUsuario)
     {
        this.inventario = inventario;
        this.coleccionUsuario = coleccionUsuario;
     }

     public Map<String, Producto> loadInventory(ArrayList<String[]> datosF){
        for(int i = 0; i < datosF.size(); i++){
            String categoria = datosF.get(i)[0];
            String name =  datosF.get(i)[1];
            Producto entry = new Producto(categoria, 1000);
            inventario.put(name, entry);
        }
        return inventario;
     }


     //opcion 1

     
}

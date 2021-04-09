import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Juan Galicia 20298
 * @author Jonathan Espinoza 20022
 */
public class Controlador {

   Map<String, Producto> inventario;
   Map<String, Producto> coleccionUsuario;
   Scanner leer = new Scanner(System.in);
    

   /**
    * Constructor
    * @param inventario Map que contiene el inventario inicial
    * @param coleccionUsuario Map que contiene la coleccion del usuario
    */
   public Controlador(Map<String, Producto> inventario, Map<String, Producto> coleccionUsuario)
   {
      this.inventario = inventario;
      this.coleccionUsuario = coleccionUsuario;
   }

     
   /** 
    * Metodo que se encarga de llenar el inventario
   * @param datosF Datos leidos del archivo de texto
   * @return Map<String, Producto> retorna el Map lleno
   */
   public Map<String, Producto> loadInventory(ArrayList<String[]> datosF){
      for(int i = 0; i < datosF.size(); i++){
         String categoria = datosF.get(i)[0];
         String name =  datosF.get(i)[1];
         Producto entry = new Producto(categoria, 1000);
         inventario.put(name, entry);
      }
      return inventario;
   }


     
      /** 
       * Metodo que se encarga de añadir productos a la coleccion del usuario
      * @return String cadena de texto con el mensaje final
      */
      //opcion 1
      public String agregarProducto()
      {
         int prev = coleccionUsuario.size();
         boolean hasCategoria = false;
         System.out.println("Ingrese la cateogoria del producto que desea agregar: \n");
         String categoria = leer.nextLine();
         for(String name : inventario.keySet())
         {
            if(inventario.get(name).getCategoria().contains((categoria)))
            {
               hasCategoria=true;
            }
         }
         if(hasCategoria)
         {
            System.out.println("Ingrese el nombre del producto que desea agregar: \n");
            String nombre = leer.nextLine();
            if(inventario.containsKey(" "+nombre))
            {
               int cantidad = verif("Ingrese la cantidad del producto: \n");
               coleccionUsuario.put(nombre, new Producto(categoria, cantidad));
            }
            else
            {
               return "No se encontró el articulo deseado";
            }
         }
         else
         {
            return "No se encontró la categoria deseada ";
         }
         if(coleccionUsuario.size()> prev)
         {
            return "Producto agregado correctamente";
         }
         else
         {
            return "Ocurrio un error al agregar el producto a la coleccion";
         }
      }


      
      /** 
       * Metodo que se encarga de mostrar la categoria de un objeto
      * @param name nombre del articulo
      * @return String cadena de texto
      */
      //opcion 2
      public String mostrarCat(String name){
         String res = null;
         for(Map.Entry<String, Producto> entry : inventario.entrySet()){
            if(entry.getKey().contains(name)){
               res += "------------------------------------\n";
               res = "Categoria de: " + name + " -> " + entry.getValue().getCategoria();
               res += "------------------------------------\n";
            }
         }
         return res;
      }

      
      /** 
      * Metodo que se encarga de mostrar los datos que se encuentran actualmente en la coleccion del usuario
      * @return String cadena de texto
      */
      //opcion 3
      public String mostrarDatos(){
         String res="";
         if(coleccionUsuario.isEmpty()){
         res = "Parece que aun no tiene ningun articulo en tu carrito, intenta agregando uno";
         }
         else{
         for(Map.Entry<String, Producto> entry : coleccionUsuario.entrySet()){
            res += "------------------------------------\n";
            res += (entry.getValue().toString(entry.getKey().toString()) + "\n");
            res += "------------------------------------\n";
         }
         }
         return res;
      }

      
      /** 
       * Metodo que se encarga de mostrar la coleccion del usuario ordenada por categoria
      * @return String cadena de texto mostrando la coleccion
      */
      //opcion 4
      public String mostrarColeccionOrdenada(){
      String res = "";
      if(coleccionUsuario.isEmpty()){
         res = "Parece que aun no tiene ningun articulo en tu carrito, intenta agregando uno";
         }
      else{
         Map<String, Producto> sortedMap = sortByValue(coleccionUsuario);
         for (Map.Entry<String, Producto> entry : sortedMap.entrySet()) {
            res += "------------------------------------\n";
            res += ("Categoria : " + entry.getValue().getCategoria() + "\n Nombre : " + entry.getKey() + "\n");
            res += "------------------------------------\n";
         }
      }
      return res;
      }

      

      
      /** 
       * Metodo que se encarga de mostrar el inventario completo
      * @return String cadena de texto que muestra el inventario 
      */
      //opcion 5
      public String mostrarInventario()
      {
         String resultado="";
         for(String name : inventario.keySet())
         {
            resultado += "------------------------------------\n";
            resultado += "\n"+("Categoria: " + inventario.get(name).getCategoria()+" Producto: "+ name);
            resultado += "------------------------------------\n";
         }
         return resultado+"\n";
      }


      
      /** 
       * Metodo que se encarga de mostrar el inventario de forma ordenada por categoria
      * @return String cadena de texto del inventario final ordenado
      */
      //opcion 6
      public String mostrarInventarioOrdenado()
      {
      String res = "";
      if(inventario.isEmpty()){
         res = "El inventario actualmente se encuentra vacio";
         }
      else{
         Map<String, Producto> sortedMap = sortByValue(inventario);
         for (Map.Entry<String, Producto> entry : sortedMap.entrySet()) {
            res += "------------------------------------\n";
            res += ("Categoria : " + entry.getValue().getCategoria() + "\n Nombre : " + entry.getKey() + "\n");
            res += "------------------------------------\n";
         }
      }
      return res;
      }



      
      /** 
       * metodo que verifica si lo ingresado por el usuario es una cadena de texto o un numero
      * @param cadena se le envia la cadena que indica lo que se le solicita al usuario
      * @return int el valor numerico
      */
      public static int verif(String cadena)
   {
      Scanner leer = new Scanner(System.in);
      int m1=-1;
         do
         {
            try
            {
                  System.out.println(cadena);
                  m1=leer.nextInt();
            }
            catch (InputMismatchException e)
            {
                  System.out.println("Valor no valido, ingrese un valor numerico");
            }
            leer.nextLine();
         }
         while(m1<0);
         
         return m1;
   }



   /** 
    * Metodo que se encarga de ordenar un Map por sus valores en el caso por categoria
    * @param unsortMap Map sin ordenar
      * @return Map<String, Producto> Retorna el Map ordenado dependiendo la condicion
      */
   private static Map<String, Producto> sortByValue(Map<String, Producto> unsortMap) {

      List<Map.Entry<String, Producto>> list =
               new LinkedList<Map.Entry<String, Producto>>(unsortMap.entrySet());

      Collections.sort(list, new Comparator<Map.Entry<String, Producto>>() {
            public int compare(Map.Entry<String, Producto> o1,
                              Map.Entry<String, Producto> o2) {
               return (o1.getValue().getCategoria()).compareTo(o2.getValue().getCategoria());
            }
      });
      Map<String, Producto> sortedMap = new LinkedHashMap<String, Producto>();
      for (Map.Entry<String, Producto> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
      }

      return sortedMap;
  }
}

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;


/**
 * @author Juan Galicia 20298
 * @author Jonathan Espinoza 20022
 * Programa de inventario y carrito de compras utilizando Hashmap, TreeMap y LinkedHashmap
 * Y el patron de diseño Factory y uso de Profiler
 *
 */
public class Main {

	private static JFileChooser file = new JFileChooser();
	private static File arch;
	private static String ruta = null;
    private static Scanner leer = new Scanner(System.in);

    private static Factory<String, Producto> structure = new Factory<String, Producto>();
    private static Controlador controlador;
	
    /** 
     * Metodo principal de ejecucion
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Map<String, Producto> inventario = null;
        Map<String, Producto> coleccionUsuario = null;
        ArrayList<String[]> datosF = readFile();
        boolean keep = true;
        boolean keep2 = false;
        String opcion="";
        String opcion2="";

        while(keep){
            System.out.println("Bienvenido! Seleccione una opcion para continuar:\n"
            			+ "1. Utilizar HashMap\n"
            			+ "2. Utilizar TreeMap\n"
            			+ "3. Utilizar LinkedHasMap\n"
            			+ "4. Salir");
            	opcion=leer.next();
            	switch(opcion){
                    case "1":
                        case "2":
                            case "3":
                                inventario = structure.getMap(Integer.parseInt(opcion));
                                coleccionUsuario = structure.getMap(Integer.parseInt(opcion));
                                controlador = new Controlador(inventario, coleccionUsuario);
                                keep2 = true;
                                keep = false;
                                break;
                    case "4":
                        System.exit(0);
                    default:
                        System.err.println("Debes ingresar un valor valido!");
                }
        }

        while(keep2){
            System.out.println("Escoga una opcion para realizar:\n"
            			+ "1. Agregar un producto a su carrito.\n"
            			+ "2. Mostrar la categoría de un producto. \n"
            			+ "3. Mostrar  los  datos  de los  productos del carrito.\n"
            			+ "4. Mostrar los  datos  de los productos del carrito, ordenados por categoria.\n"
                        + "5. Mostrar inventario.\n"
                        + "6. Mostrar inventario ordenado por categoria.\n"+
                        "7. Salir");
            opcion2=leer.next();
            controlador.loadInventory(datosF);
            switch(opcion2){
                case "1":
                    System.out.println(controlador.agregarProducto());
                    break;

                case "2":
                    Scanner l = new Scanner(System.in);
                    System.out.println("Ingrese el nombre del producto");
                    String name = l.nextLine();
                    System.out.println(controlador.mostrarCat(name));
                    break;

                case "3":
                    System.out.println(controlador.mostrarDatos());
                    break;

                case "4":
                    System.out.println(controlador.mostrarColeccionOrdenada());
                    break;

                case "5":
                    System.out.println(controlador.mostrarInventario());
                    break;

                case "6":
                    System.out.println(controlador.mostrarInventarioOrdenado());
                    break;

                case "7":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Debes ingresar un valor valido!");
                    break;
            }

        }
	}
	
	
    /** 
     * Metodo que se encarga de leer el archivo
     * @return ArrayList<String[]> retorna los datos obtenidos
     * @throws IOException
     */
    public static ArrayList<String[]> readFile() throws IOException
	{
		
		System.out.println("Bienvenido, primero debe de seleccionar el archivo");
		int r = file.showOpenDialog(null);
		ArrayList<String> data= new ArrayList<>();
		String line="";
        ArrayList<String[]> datosF = new ArrayList<String[]>();
        
        if (r == JFileChooser.APPROVE_OPTION) {
            arch = file.getSelectedFile();
            ruta = arch.getAbsolutePath();
            System.out.println("\nArchivo a utilizar: " + arch.getAbsolutePath());
            try{
                FileReader read = new FileReader(ruta);
                BufferedReader read1 = new BufferedReader(read);
                data.add(read1.readLine());
                while((line = read1.readLine()) != null)
                {
                	data.add(line);
                }
            }
            catch(ArithmeticException | IOException | NumberFormatException e){
            System.out.println(e.toString());
            }
        }
        for(int i = 0; i<data.size(); i++)
        {
            String[] l = data.get(i).split("\\|");
            l[1]=l[1].replaceAll("\\s", " ");
            l[0]=l[0].replaceAll("\\s", " ");
            datosF.add(l);
        }

        return datosF;
	}

}

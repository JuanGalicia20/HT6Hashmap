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
 * 
 */

/**
 * @author juana
 *
 */
public class Main {

	private static JFileChooser file = new JFileChooser();
	private static File arch;
	private static String ruta = null;
    private static Scanner leer = new Scanner(System.in);

    private static Factory<String, Producto> structure = new Factory<String, Producto>();
    private static Controlador controlador = new Controlador();
	

	public static void main(String[] args) throws IOException {
        Map<String, Producto> inventario = null;
        Map<String, Producto> coleccionUsuario = null;
		readFile();
        boolean keep = true;
        boolean keep2 = false;
        String opcion="";

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
                        + "6. ");

        }
	}
	
	public static void readFile() throws IOException
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
            datosF.add(l);
        }
	}

}

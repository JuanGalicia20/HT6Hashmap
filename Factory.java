
import java.util.*;

/**
 * @author Juan Galicia 20298
 * @author Jonathan Espinoza 20022
 */
public class Factory<E, F> {
    
    
    /** 
     * Patron Factory
     * @param entry Indicador del tipo de objeto que se desea instanciar
     * @return Map el tipo de objeto instanciado
     */
    public Map getMap(int entry){
        switch(entry){
            case 1: 
                return new HashMap<E,F>();
            case 2:
                return new TreeMap<E,F>();
            case 3: 
                return new LinkedHashMap<E,F>();
            default:
                System.err.println("Debes ingresar un valor valido!");
                return null;
        }
       
    }
}

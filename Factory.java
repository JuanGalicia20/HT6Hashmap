
import java.util.*;

public class Factory<E, F> {
    
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

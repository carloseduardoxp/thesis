
import java.util.*;

public class Teste {

    public static <T> List<T> merge(List<T>... args) {
        final List<T> result = new ArrayList<>();
    
        for (List<T> list : args) {
            result.addAll(list);
        }
    
        return result;
    }
    
}
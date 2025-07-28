
import java.util.Arrays;

public class Teste {

    
    public static void main(String[] args) {
        int[] ia = {99, 11, 7, 21, 4, 2};
        ia = Arrays.stream(ia).
            boxed().
            sorted((a, b) -> b.compareTo(a)). // sort descending
            mapToInt(i -> i).
            toArray();

            
    }
    
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {

    public static void main(String[] args) {        
        List<Integer> a = new ArrayList<>(Arrays.asList(21, 41, 96, 02));
        List<Integer> b = new ArrayList<>(Arrays.asList(21, 96, 32, 952, 1835));
        
        b.removeAll(a);
        
        // now list b contains (32, 952, 1835)
        
        a.addAll(b);
        
        // now list a contains (21, 41, 96, 02, 32, 952, 1835)
    }
}
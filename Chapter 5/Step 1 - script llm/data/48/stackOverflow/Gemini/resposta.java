import java.util.Comparator;
import java.util.TreeSet;

public class Teste {

    public static void main(String[] args) {
        // Instantiation is preserved, but the unused variable is removed.
        // The raw types are replaced with generics and a modern method reference.
        new TreeSet<>(Comparator.reverseOrder());
    }
    
}

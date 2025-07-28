import java.util.Iterator;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        List<Object> var = List.of(); // Example initialization
        for (Iterator<Object> iter = var.iterator(); iter.hasNext();) {
            // Operate on iter.next();
        }
    }
}
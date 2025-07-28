import java.util.TreeSet;
import java.util.Comparator;

public class Teste {
    public static void main(String[] args) {
        new TreeSet<String>(new Comparator<String>() {
            public int compare(String i1, String i2) {
                return i2.compareTo(i1);
            }
        });
    }
}
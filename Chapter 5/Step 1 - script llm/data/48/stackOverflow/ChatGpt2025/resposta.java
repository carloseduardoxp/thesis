import java.util.Comparator;
import java.util.TreeSet;

public class Teste {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            public int compare(String i1, String i2) {
                return i2.compareTo(i1);
            }
        });
        // Use treeSet as needed
    }

}
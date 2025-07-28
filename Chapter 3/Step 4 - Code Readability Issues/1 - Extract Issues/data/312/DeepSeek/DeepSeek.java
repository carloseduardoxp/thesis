
import java.util.Set;
import java.util.TreeSet;

public class DeepSeek {

    public static void main(String[] args) {

        Set<String> orderedSet = new TreeSet<>();
        orderedSet.add("Banana");
        orderedSet.add("Apple");
        orderedSet.add("Cherry");

// Elements are automatically sorted (natural ordering)
        System.out.println(orderedSet); // [Apple, Banana, Cherry]

    }

}

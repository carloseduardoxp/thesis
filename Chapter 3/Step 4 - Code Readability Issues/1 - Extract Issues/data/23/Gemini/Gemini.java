import java.util.ArrayList;
import java.util.List;

public class Gemini {

    public static void main(String[] args) {
        // Without generics (older way, less type-safe)
        List numbers = new ArrayList();
        numbers.add(10);
        numbers.add("hello"); // This would compile but cause a runtime error

        // With generics (type-safe)
        List<Integer> ages = new ArrayList<>();
        ages.add(25);
        // ages.add("thirty"); // This would not compile - type mismatch

        int firstAge = ages.get(0); // No need for explicit casting

        // A simple generic method
        printItem("Java");
        printItem(123);
    }

    // A generic method
    public static <T> void printItem(T item) {
        System.out.println("Item: " + item.getClass().getName() + " - Value: " + item);
    }
}

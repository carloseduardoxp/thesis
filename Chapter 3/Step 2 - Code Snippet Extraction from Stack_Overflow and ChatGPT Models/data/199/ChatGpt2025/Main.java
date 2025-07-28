import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        list.add("Orange"); // Add to the end

        System.out.println(list); // Output: [Apple, Banana, Orange]
    }
}

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Convert to array
        String[] array = list.toArray(new String[0]);

        // Print the array elements
        for (String fruit : array) {
            System.out.println(fruit);
        }
    }
}

import java.util.ArrayList;

public class SearchArrayList {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");

        // Check if "Banana" exists
        boolean hasBanana = fruits.contains("Banana");
        System.out.println("Does the list contain 'Banana'? " + hasBanana); // Output: true

        // Check if "Mango" exists
        boolean hasMango = fruits.contains("Mango");
        System.out.println("Does the list contain 'Mango'? " + hasMango);   // Output: false
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating an empty List of Strings
        List<String> stringList = new ArrayList<>();

        // Creating a List of Integers with initial values
        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // Creating a List of Doubles
        List<Double> doubleList = new ArrayList<>();

        // Adding elements to the lists
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        // Printing the lists
        System.out.println("String List: " + stringList);
        System.out.println("Integer List: " + intList);
        System.out.println("Double List: " + doubleList);
    }
}

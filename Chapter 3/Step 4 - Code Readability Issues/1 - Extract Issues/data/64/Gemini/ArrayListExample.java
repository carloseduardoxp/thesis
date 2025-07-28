import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        // Creating an ArrayList to store strings
        // The diamond operator (<>) is used for type inference, making the code cleaner.
        List<String> stringList = new ArrayList<>();

        // Adding elements to the ArrayList
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Grapes");

        // Displaying the ArrayList
        System.out.println("Initial ArrayList: " + stringList); // Output: [Apple, Banana, Orange, Grapes]

        // Adding an element at a specific index
        stringList.add(1, "Mango"); // Inserts "Mango" at index 1
        System.out.println("After inserting at index 1: " + stringList); // Output: [Apple, Mango, Banana, Orange, Grapes]

        // Accessing an element by index
        String secondElement = stringList.get(1);
        System.out.println("Element at index 1: " + secondElement); // Output: Mango

        // Updating an element at a specific index
        stringList.set(2, "Pear"); // Replaces "Banana" with "Pear"
        System.out.println("After updating index 2: " + stringList); // Output: [Apple, Mango, Pear, Orange, Grapes]

        // Removing an element by index
        stringList.remove(3); // Removes "Orange"
        System.out.println("After removing element at index 3: " + stringList); // Output: [Apple, Mango, Pear, Grapes]

        // Removing a specific element
        stringList.remove("Grapes"); // Removes the first occurrence of "Grapes"
        System.out.println("After removing 'Grapes': " + stringList); // Output: [Apple, Mango, Pear]

        // Checking if an element exists
        boolean containsMango = stringList.contains("Mango");
        System.out.println("Contains 'Mango'? " + containsMango); // Output: true

        // Getting the size of the ArrayList
        int size = stringList.size();
        System.out.println("Size of ArrayList: " + size); // Output: 3

        // Iterating through the ArrayList
        System.out.println("Iterating using a for-each loop:");
        for (String fruit : stringList) {
            System.out.println(fruit);
        }
        //clear all elements of arraylist
        stringList.clear();
        System.out.println("ArrayList after clearing all elements:"+stringList); // Output: []

        // Checking if the ArrayList is empty
        boolean isEmpty = stringList.isEmpty();
        System.out.println("Is ArrayList empty? " + isEmpty); // Output: true

        //Creating an ArrayList of Integer type
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        System.out.println("Integer ArrayList: " + integerList);

        //Creating an ArrayList of Double type
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.5);
        doubleList.add(30.5);
        System.out.println("Double ArrayList: " + doubleList);
    }
}

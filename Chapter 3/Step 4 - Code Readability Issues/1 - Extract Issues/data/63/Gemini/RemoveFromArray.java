import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveFromArray {
    public static void main(String[] args) {
        String[] originalArray = {"apple", "banana", "cherry", "date", "banana"};
        String elementToRemove = "banana";

        // Convert the array to an ArrayList
        List<String> list = new ArrayList<>(Arrays.asList(originalArray));

        // Remove the first occurrence of the element
        list.remove(elementToRemove);
        System.out.println("After removing first '" + elementToRemove + "': " + list);

        // To remove all occurrences, you can use a loop or removeAll
        list = new ArrayList<>(Arrays.asList(originalArray)); // Reset the list
        list.removeAll(List.of(elementToRemove)); // Requires Java 9+ or create a Collection manually
        System.out.println("After removing all '" + elementToRemove + "': " + list);

        // If you need to go back to a String array
        String[] newArray = list.toArray(new String[0]);
        System.out.println("New array: " + Arrays.toString(newArray));
    }
}

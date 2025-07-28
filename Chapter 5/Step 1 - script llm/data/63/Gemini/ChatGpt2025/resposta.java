import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveFromArray {
    private static final String ELEMENT_TO_REMOVE = "banana";

    public static void main(String[] args) {
        String[] originalArray = {"apple", ELEMENT_TO_REMOVE, "cherry", "date", ELEMENT_TO_REMOVE};

        // Convert the array to an ArrayList
        List<String> list = new ArrayList<>(Arrays.asList(originalArray));

        // Remove the first occurrence of the element
        list.remove(ELEMENT_TO_REMOVE);
        System.out.println("After removing first '" + ELEMENT_TO_REMOVE + "': " + list);

        // To remove all occurrences, you can use a loop or removeAll
        list = new ArrayList<>(Arrays.asList(originalArray)); // Reset the list
        list.removeAll(List.of(ELEMENT_TO_REMOVE)); // Requires Java 9+ or create a Collection manually
        System.out.println("After removing all '" + ELEMENT_TO_REMOVE + "': " + list);

        // If you need to go back to a String array
        String[] newArray = list.toArray(new String[0]);
        System.out.println("New array: " + Arrays.toString(newArray));
    }
}

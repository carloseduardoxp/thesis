import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("apple");
        listWithDuplicates.add("banana");
        listWithDuplicates.add("apple");
        listWithDuplicates.add("orange");
        listWithDuplicates.add("banana");

        System.out.println("Original List: " + listWithDuplicates);

        // Convert the list to a HashSet to remove duplicates
        Set<String> uniqueElements = new HashSet<>(listWithDuplicates);

        // Convert the Set back to a List if needed
        List<String> listWithoutDuplicates = new ArrayList<>(uniqueElements);

        System.out.println("List without duplicates (order not preserved): " + listWithoutDuplicates);
    }
}

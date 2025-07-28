import java.util.*;
import java.util.stream.Collectors;

class Teste {
    public static void main(String[] args) {
        // Define an array with duplicates
        String[] arrWithDuplicates = {"apple", "orange", "banana", "orange", "apple"};

        // Convert the array to a Set to remove duplicates
        Set<String> setWithoutDuplicates = new LinkedHashSet<>(Arrays.asList(arrWithDuplicates));

        // Convert the Set back to an array
        String[] arrWithoutDuplicates = setWithoutDuplicates.toArray(new String[0]);

        // Print the array without duplicates
        System.out.println(Arrays.toString(arrWithoutDuplicates));

        // Define a list with duplicates
        List<String> listWithDuplicates = Arrays.asList("apple", "orange", "banana", "orange", "apple");

        // Create a Stream from the list and remove duplicates
        List<String> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        // Print the list without duplicates
        System.out.println(listWithoutDuplicates);


    }
}
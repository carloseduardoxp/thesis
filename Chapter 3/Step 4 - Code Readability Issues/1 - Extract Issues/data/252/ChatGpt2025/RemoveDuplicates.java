import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5);

        // Convert list to set to remove duplicates
        Set<Integer> setWithoutDuplicates = new HashSet<>(listWithDuplicates);

        // If you need a list again
        List<Integer> listWithoutDuplicates = new ArrayList<>(setWithoutDuplicates);

        System.out.println("Original list: " + listWithDuplicates);
        System.out.println("List without duplicates: " + listWithoutDuplicates);
    }
}

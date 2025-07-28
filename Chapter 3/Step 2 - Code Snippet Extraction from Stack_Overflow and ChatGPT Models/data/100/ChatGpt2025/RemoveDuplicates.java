import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> listWithDuplicates = Arrays.asList("apple", "banana", "apple", "orange");

        Set<String> set = new HashSet<>(listWithDuplicates);  // removes duplicates
        List<String> listWithoutDuplicates = new ArrayList<>(set);

        System.out.println(listWithoutDuplicates);
    }
}

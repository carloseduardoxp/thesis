import java.util.*;

public class NameSorter {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Zoe");
        names.add("Mike");

        // Sort in reverse (descending) order
        Collections.sort(names, Comparator.reverseOrder());

        System.out.println("Names in reverse order: " + names);
    }
}

import java.util.*;

public class SearchListExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        String searchItem = "banana";
        boolean found = list.contains(searchItem);

        if (found) {
            System.out.println(searchItem + " is in the list.");
        } else {
            System.out.println(searchItem + " is not in the list.");
        }
    }
}

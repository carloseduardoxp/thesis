import java.util.ArrayList;
import java.util.List;

public class SearchList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");

        boolean hasBanana = fruits.contains("Banana");
        System.out.println("Does the list contain Banana? " + hasBanana); // Output: true

        boolean hasKiwi = fruits.contains("Kiwi");
        System.out.println("Does the list contain Kiwi? " + hasKiwi);     // Output: false
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseListExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        myList.add("Grape");

        System.out.println("Original List: " + myList);

        Collections.reverse(myList); // Reverses the list in-place

        System.out.println("Reversed List: " + myList);
    }
}

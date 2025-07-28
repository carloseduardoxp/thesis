import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");

        System.out.println("Original list: " + myList);
        
        // Shuffle the list
        Collections.shuffle(myList);
        
        System.out.println("Shuffled list: " + myList);
    }
}

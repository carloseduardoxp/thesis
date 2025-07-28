import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExample {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");
        items.add("Date");

        System.out.println("Before shuffle: " + items);
        
        Collections.shuffle(items);

        System.out.println("After shuffle: " + items);
    }
}

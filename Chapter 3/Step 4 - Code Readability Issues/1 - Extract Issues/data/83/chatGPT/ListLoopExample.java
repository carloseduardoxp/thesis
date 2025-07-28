import java.util.List;
import java.util.ArrayList;

public class ListLoopExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

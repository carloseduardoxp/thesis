import java.util.ArrayList;
import java.util.List;

public class LoopList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Using Enhanced for-loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

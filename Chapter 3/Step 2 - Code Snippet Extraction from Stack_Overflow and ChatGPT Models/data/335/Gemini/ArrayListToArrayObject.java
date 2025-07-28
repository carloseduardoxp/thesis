import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArrayObject {
    public static void main(String[] args) {
        ArrayList<String> fruitsList = new ArrayList<>();
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Orange");

        // Convert ArrayList to an Object array
        Object[] fruitsArray = fruitsList.toArray();

        System.out.println("Fruits Array (Object[]): " + Arrays.toString(fruitsArray));

        // You can iterate and cast elements if needed
        for (Object obj : fruitsArray) {
            String fruit = (String) obj;
            System.out.println("Fruit: " + fruit);
        }
    }
}

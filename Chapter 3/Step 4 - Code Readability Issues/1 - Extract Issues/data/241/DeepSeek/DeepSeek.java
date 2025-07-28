
import java.util.Arrays;
import java.util.List;

public class DeepSeek {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange", "grape");

// Using contains() - returns boolean
        boolean containsBanana = list.contains("banana");

// Using indexOf() - returns index or -1 if not found
        int index = list.indexOf("orange");

// Manual iteration
        for (String fruit : list) {
            if (fruit.equals("grape")) {
                System.out.println("Found grape!");
                break;
            }
        }

    }

}

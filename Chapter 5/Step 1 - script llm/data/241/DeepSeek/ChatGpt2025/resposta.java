import java.util.Arrays;
import java.util.List;

public class DeepSeek {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange", "grape");

        // Manual iteration
        for (String fruit : list) {
            if (fruit.equals("grape")) {
                System.out.println("Found grape!");
                break;
            }
        }

    }

}
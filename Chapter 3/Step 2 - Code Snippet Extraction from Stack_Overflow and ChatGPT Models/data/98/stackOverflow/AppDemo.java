import java.util.Arrays;

public class AppDemo {

    public static void main(String[] args) {

        String input = "world";
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        System.out.println(sorted);
    }
}
import java.util.Arrays;

public class SortString {
    public static String sortString(String input) {
        // Convert string to char array
        char[] chars = input.toCharArray();
        
        // Sort the char array
        Arrays.sort(chars);
        
        // Convert back to string
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "hello";
        String sorted = sortString(str);
        System.out.println(sorted); // Output: ehllo
    }
}

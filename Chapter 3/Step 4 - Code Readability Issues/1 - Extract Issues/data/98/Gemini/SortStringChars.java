import java.util.Arrays;

public class SortStringChars {
    public static void main(String[] args) {
        String originalString = "programming";
        char[] charArray = originalString.toCharArray();

        Arrays.sort(charArray); // Sorts the character array

        String sortedString = new String(charArray); // Converts char array back to String

        System.out.println("Original String: " + originalString);
        System.out.println("Sorted String: " + sortedString); // Output: aggimmnoprr
    }
}

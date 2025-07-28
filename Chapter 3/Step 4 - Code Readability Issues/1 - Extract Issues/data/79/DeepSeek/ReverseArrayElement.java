
import java.util.Arrays;

public class ReverseArrayElement {
    public static void main(String[] args) {
        String[] array = {"hello", "world", "java"};
        int indexToReverse = 1; // Reverse the element at index 1 ("world")
        
        if (indexToReverse >= 0 && indexToReverse < array.length) {
            String element = array[indexToReverse];
            String reversed = new StringBuilder(element).reverse().toString();
            array[indexToReverse] = reversed;
        }
        
        System.out.println(Arrays.toString(array)); 
        // Output: [hello, dlrow, java]
    }
}

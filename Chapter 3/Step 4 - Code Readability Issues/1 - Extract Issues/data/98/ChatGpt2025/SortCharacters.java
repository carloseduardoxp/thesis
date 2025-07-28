import java.util.Arrays;

public class SortCharacters {
    public static void main(String[] args) {
        String input = "programming";
        
        // Step 1: Convert to char array
        char[] characters = input.toCharArray();
        
        // Step 2: Sort the array
        Arrays.sort(characters);
        
        // Step 3: Convert back to string
        String sorted = new String(characters);
        
        System.out.println("Sorted string: " + sorted);
    }
}

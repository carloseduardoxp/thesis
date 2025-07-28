
import java.util.Arrays;

class Teste {
    public static void main(String[] args) {
        String inputString = "hello world";

        // Convert the input string to a character array
        char[] charArray = inputString.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        String sortedString = new String(charArray);

        // Print the sorted string
        System.out.println(sortedString);


    }
}
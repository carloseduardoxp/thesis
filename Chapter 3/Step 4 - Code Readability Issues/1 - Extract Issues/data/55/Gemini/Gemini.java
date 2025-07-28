
public class Gemini {

    public static void main(String[] args) {

        String originalString = "This is a test string with the word test in it.";
        String substringToRemove = "test";
        String result = originalString.replace(substringToRemove, "");
        System.out.println(result); // Output: This is a  string with the word  in it.

    }
}

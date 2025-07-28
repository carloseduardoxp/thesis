public class Gemini {
    public static void main(String[] args) {
        String originalString = "hello";
        StringBuilder reversedString = new StringBuilder(originalString).reverse();
        String result = reversedString.toString();
        System.out.println(result); // Output: olleh
    }
}

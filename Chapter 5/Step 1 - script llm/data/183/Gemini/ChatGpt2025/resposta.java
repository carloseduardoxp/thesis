public class DeleteLastCharString {
    public static void main(String[] args) {
        String originalString = "Hello!";
        String newString = ""; // Initialize with empty string for safety

        if (!originalString.isEmpty()) {
            newString = originalString.substring(0, originalString.length() - 1);
        }

        System.out.println("Original String: " + originalString);
        System.out.println("New String: " + newString); // Output: Hello
    }
}
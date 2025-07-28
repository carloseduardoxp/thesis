public class RemoveCharsReplace {
    public static void main(String[] args) {
        String originalString = "Hello, World! 123";

        // 1. Remove a specific character using replace(char, char)
        String noExclamation = originalString.replace('!', ' '); // Replaces with a space
        System.out.println("No '!' (replaced with space): " + noExclamation); // Output: Hello, World  123

        String noComma = originalString.replace(",", ""); // Removes the comma completely
        System.out.println("No ',' (removed): " + noComma); // Output: Hello World! 123

        // 2. Remove a specific substring using replace(CharSequence, CharSequence)
        String noWorld = originalString.replace("World", "");
        System.out.println("No 'World': " + noWorld); // Output: Hello, ! 123

        // 3. Remove digits using replaceAll (regex)
        String noDigits = originalString.replaceAll("\\d", ""); // \\d matches any digit
        System.out.println("No digits: " + noDigits); // Output: Hello, World!

        // 4. Remove all non-alphanumeric characters (except space) using replaceAll (regex)
        String onlyAlphaNumericSpace = originalString.replaceAll("[^a-zA-Z0-9 ]", ""); // ^ negates the set
        System.out.println("Only alphanumeric and space: " + onlyAlphaNumericSpace); // Output: Hello World 123
    }
}

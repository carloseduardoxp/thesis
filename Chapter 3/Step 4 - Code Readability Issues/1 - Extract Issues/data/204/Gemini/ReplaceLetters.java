public class ReplaceLetters {
    public static void main(String[] args) {
        String originalString = "hello world";

        // Replace all 'o' with 'x'
        String newString1 = originalString.replace('o', 'x');
        System.out.println("Replacing 'o' with 'x': " + newString1); // Output: hellx wxrld

        // Replace "ll" with "zz"
        String newString2 = originalString.replace("ll", "zz");
        System.out.println("Replacing \"ll\" with \"zz\": " + newString2); // Output: hezzo world
    }
}

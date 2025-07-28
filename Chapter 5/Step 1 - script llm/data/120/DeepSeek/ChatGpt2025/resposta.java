public class DeepSeek {

    public static void main(String[] args) {

        String original = "Hello World!";

        // Remove all 'l' characters and print the result
        System.out.println(original.replace("l", "")); // "Heo Word!"

        // Remove first occurrence only and print the result
        System.out.println(original.replaceFirst("l", "")); // "Helo World!"
    }

}
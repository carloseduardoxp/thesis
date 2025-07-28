public class DeepSeek {

    public static void main(String[] args) {

        String original = "Hello World!";

// Remove all 'l' characters
        System.out.println(original.replace("l", ""));
// Result: "Heo Word!"

// Remove first occurrence only
        System.out.println(original.replaceFirst("l", ""));
// Result: "Helo World!"

    }

}

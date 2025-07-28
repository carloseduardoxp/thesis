
public class DeepSeek {

    public static void main(String[] args) {

        String original = "Hello World!";

// Remove all 'l' characters
        String modified = original.replace("l", "");
// Result: "Heo Word!"

// Remove first occurrence only
        String modifiedFirst = original.replaceFirst("l", "");
// Result: "Helo World!"

    }

}

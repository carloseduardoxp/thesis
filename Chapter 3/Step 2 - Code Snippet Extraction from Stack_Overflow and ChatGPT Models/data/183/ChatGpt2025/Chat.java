
public class Chat {

    public static void main(String[] args) {

        String original = "Hello!";
        if (original != null && original.length() > 0) {
            String modified = original.substring(0, original.length() - 1);
            System.out.println(modified);  // Output: Hello
        }

    }

}

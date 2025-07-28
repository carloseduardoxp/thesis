public class Chat {

    public static void main(String[] args) {
        String original = "Hello world";
        String toRemove = "world";

        String result = original.replace(toRemove, "");
        System.out.println(result); // Output: "Hello "
    }
}
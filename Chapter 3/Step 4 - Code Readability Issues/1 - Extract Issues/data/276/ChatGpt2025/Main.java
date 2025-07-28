
public class Main {

    public static void main(String[] args) {
        String text = "Hello, world!";
        int position = text.indexOf("world");

        if (position != -1) {
            System.out.println("Found at index: " + position);
        } else {
            System.out.println("Substring not found.");
        }
    }
}

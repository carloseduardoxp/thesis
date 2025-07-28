public class RemoveNumbers {
    public static void main(String[] args) {
        String input = "Order 123 for 5 items at 19.99 each";
        String output = input.replaceAll("\\d", "");
        System.out.println("Original: " + input);
        System.out.println("Without numbers: " + output);
    }
}
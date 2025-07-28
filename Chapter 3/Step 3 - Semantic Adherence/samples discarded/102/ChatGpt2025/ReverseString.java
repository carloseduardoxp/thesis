public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello";
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed); // Output: olleH
    }
}

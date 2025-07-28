public class Gemini {

    public static void main(String[] args) {

        int x = 5;

        // Postfix increment
        int y = x++; // y will be 5, x will be 6
        System.out.println("x after postfix: " + x); // Output: 6
        System.out.println("y (result of postfix): " + y); // Output: 5

        int a = 5;

        // Prefix increment
        int b = ++a; // a will be 6, b will be 6
        System.out.println("a after prefix: " + a); // Output: 6
        System.out.println("b (result of prefix): " + b); // Output: 6

        // You can also use it directly without assignment
        int counter = 10;
        counter++; // counter is now 11
        System.out.println("counter: " + counter); // Output: 11

    }

}
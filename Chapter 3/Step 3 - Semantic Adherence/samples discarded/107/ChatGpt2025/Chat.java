
public class Chat {

    public static void main(String[] args) {

        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

    }

}

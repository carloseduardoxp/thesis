
public class DeepSeek {

    public static void main(String[] args) {

        try {
            // Code that might throw an exception
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            // Handle the specific exception
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }

    }

}

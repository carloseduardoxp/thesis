public class Chat {

    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int result = 10 / 0;  // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            // Handle the exception here
            System.out.println("Cannot divide by zero!");
        }
    }
}

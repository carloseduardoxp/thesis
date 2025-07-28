public class DeepSeek {

    public static void main(String[] args) {

        try {
            // Code that might throw an exception
            throw new ArithmeticException("/ by zero");
        } catch (ArithmeticException e) {
            // Handle the specific exception
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }

    }

}

public class Chat {

    public static void main(String[] args) {

        try {
            // Code that may throw an exception
            // The following expression is used to trigger the exception
            // without creating an unused variable.
            int i = 10 / 0;
        } catch (ArithmeticException e) {
            // Handle the exception here
            System.out.println("Cannot divide by zero!");
        }

    }

}

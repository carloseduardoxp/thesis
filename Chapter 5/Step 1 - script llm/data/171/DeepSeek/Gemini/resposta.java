public class DeepSeek {

    public static void main(String[] args) {

        try {
            // Code that might throw an exception
            // The assignment to "result" was removed as it was unused.
            // Math.floorDiv is used to preserve the ArithmeticException.
            Math.floorDiv(10, 0);
        } catch (ArithmeticException e) {
            // Handle the specific exception
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions (more general)
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // This block always executes (optional)
            System.out.println("This executes regardless of exceptions");
        }
    }
}

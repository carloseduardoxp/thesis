public class ErrorExample {
  public static void main(String[] args) {
     try {
        // Code that may throw an error
        throw new AssertionError("This is a demonstration error.");
     } catch (Error e) {
        // Handle the error
        System.err.println("An error occurred: " + e.getMessage());
     }
  }
}

public class ErrorExample {
  public static void main(String[] args) {
     try {
        // Code that may throw an error
        int result = 10 / 0;
     } catch (Error e) {
        // Handle the error
        System.err.println("An error occurred: " + e.getMessage());
     }
  }
}
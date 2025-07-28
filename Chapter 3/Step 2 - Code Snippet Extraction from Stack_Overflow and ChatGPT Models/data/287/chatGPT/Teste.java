public class Teste {
  
  public static void main(String[] args) {

      // Call the method with all arguments
      printMessage("Hello, world!", 3, true);

      // Call the method with only the message argument
      printMessage("Hello, world!", 1, false);

      // Call the method with only the message and count arguments
      printMessage("Hello, world!", 2);

  }

  // Define the method with default values
  public void printMessage(String message, int count, boolean bold) {
      // Use the ternary operator to check if the parameter was passed in
      count = (count > 0) ? count : 1;
      bold = (bold) ? true : false;

      // Implementation here
  }

}

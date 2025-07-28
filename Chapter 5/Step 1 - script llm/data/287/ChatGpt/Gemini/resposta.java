public class Teste {

  private static final String GREETING = "Hello, world!";

  public static void main(String[] args) {

    // Call the method with all arguments
    printMessage(GREETING, 3, true);

    // Call the method with only the message argument
    printMessage(GREETING);

    // Call the method with only the message and count arguments
    printMessage(GREETING, 2);
  }

  // Define the primary method, now static and with an implementation
  public static void printMessage(String message, int count, boolean bold) {
    for (int i = 0; i < count; i++) {
      if (bold) {
        System.out.println("<b>" + message + "</b>");
      } else {
        System.out.println(message);
      }
    }
  }

  // Overloaded method to provide a default value for the 'bold' parameter
  public static void printMessage(String message, int count) {
    printMessage(message, count, false);
  }

  // Overloaded method to provide default values for 'count' and 'bold'
  public static void printMessage(String message) {
    printMessage(message, 1);
  }
}

public class ExceptionExample {
  public static void main(String[] args) {
      try {
          int a = 5;
          int b = 0;
          int c = a / b;
          System.out.println("Result: " + c);
      } catch (ArithmeticException e) {
          System.out.println("An arithmetic exception occurred: " + e.getMessage());
          e.printStackTrace();
      } catch (Exception e) {
          System.out.println("An exception occurred: " + e.getMessage());
          e.printStackTrace();
      }
  }
}

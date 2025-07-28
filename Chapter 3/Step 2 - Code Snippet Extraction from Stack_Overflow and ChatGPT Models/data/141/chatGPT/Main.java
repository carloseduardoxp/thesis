public class Main {
  public static void main(String[] args) {
      int maxProduct = 0;

      for (int i = 1; i < 1000; i++) {
          for (int j = 1; j < 1000; j++) {
              int product = i * j;
              if (product < 1000 && product > maxProduct) {
                  maxProduct = product;
              }
          }
      }

      System.out.println("The largest product of two numbers less than 1000 is: " + maxProduct);
  }
}

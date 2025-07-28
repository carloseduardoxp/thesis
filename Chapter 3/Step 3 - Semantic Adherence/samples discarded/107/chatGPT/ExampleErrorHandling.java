import java.io.FileInputStream;
import java.io.IOException;


public class ExampleErrorHandling {
  public static void main(String[] args) {
      try {
          int numerator = 10;
          int denominator = 0;
          int result = numerator / denominator;
          System.out.println("Result: " + result);
      } catch (ArithmeticException e) {
          System.out.println("Error: " + e.getMessage());
      }
  }
}


class Example1ErrorHandling {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("example.txt");
            int data = fileInputStream.read();
            while(data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
}

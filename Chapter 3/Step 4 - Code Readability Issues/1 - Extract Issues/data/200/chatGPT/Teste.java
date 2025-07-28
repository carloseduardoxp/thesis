public class Teste {
  public static void main(String[] args) {
    String input = "123";

    try {
        int num = Integer.parseInt(input);
        System.out.println("The input is an integer: " + num);
    } catch (NumberFormatException e) {
        System.out.println("The input is not an integer");
    }

  }
}

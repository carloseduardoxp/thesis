public class Teste {
  public static void main(String[] args) {
    String text = "Hello, world! How are you doing today, world?";
    String search = "world";
    int count = countOccurrences(text, search);
    System.out.println("The string \"" + search + "\" occurs " + count + " times.");

  }
}

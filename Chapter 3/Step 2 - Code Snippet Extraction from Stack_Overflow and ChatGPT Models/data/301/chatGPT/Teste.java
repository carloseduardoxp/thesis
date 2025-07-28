public class Teste {
  public static void main(String[] args) {
    Process process = Runtime.getRuntime().exec("myCommand");
    // ...
    process.destroy();
  }
}

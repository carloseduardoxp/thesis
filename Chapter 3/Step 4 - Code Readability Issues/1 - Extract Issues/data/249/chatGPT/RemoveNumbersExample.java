public class RemoveNumbersExample {
  public static void main(String[] args) {
      String str = "abc123def456ghi789";
      String strWithoutNumbers = str.replaceAll("\\d", ""); // remove all digits
      
      System.out.println(strWithoutNumbers);
  }
}

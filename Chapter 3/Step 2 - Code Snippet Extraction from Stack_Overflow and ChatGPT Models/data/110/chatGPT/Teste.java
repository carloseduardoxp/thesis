import org.apache.commons.text.StringEscapeUtils;

public class Teste {
  public static void main(String[] args) {
    String text = "This is a \"quoted\" string.";
    String escapedText = StringEscapeUtils.escapeJava(text);
    System.out.println(escapedText);


  }
}

import java.text.DecimalFormat;

public class Teste {
  public static void main(String[] args) {
    float value = 3.14159f;
    DecimalFormat df = new DecimalFormat("#.##"); // format to 2 decimal places
    String roundedString = df.format(value); // "3.14"
  }
}


import java.util.ArrayList;

public class Teste {
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("one");
    arrayList.add("two");
    arrayList.add("three");

    String[] array = arrayList.toArray(new String[arrayList.size()]);

    // Now you can use the 'array' as an array of strings.

  }
}

import java.util.ArrayList;

public class Teste {
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("one");
    arrayList.add("two");
    arrayList.add("three");

    arrayList.toArray(new String[0]);
  }
}

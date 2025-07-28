
public class Teste {
  public static void main(String[] args) {
    int[] originalArray = {1, 2, 3, 4, 5};
    int[] newArray = new int[originalArray.length];
    System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

  }
}

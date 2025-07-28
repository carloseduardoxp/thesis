public class Teste {
  public static void main(String[] args) {
    int[] originalArray = {1, 2, 3};
    int[] newArray = new int[originalArray.length + 1];
    System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
    newArray[newArray.length - 1] = 4;

    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    list.add(4);

  }
}

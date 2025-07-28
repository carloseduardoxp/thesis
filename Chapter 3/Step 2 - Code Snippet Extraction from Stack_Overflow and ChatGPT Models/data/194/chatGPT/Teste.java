public class Teste {
  public static void main(String[] args) {
    int[] originalArray = {1, 2, 3, 4, 5};
    int element = 6;
    int[] newArray = insertElement(originalArray, element);

  }

  public static int[] insertElement(int[] originalArray, int element) {
    int[] newArray = new int[originalArray.length + 1];
    for (int i = 0; i < originalArray.length; i++) {
        newArray[i] = originalArray[i];
    }
    newArray[newArray.length - 1] = element;
    return newArray;
}

}

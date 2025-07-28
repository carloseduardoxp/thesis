import java.util.Arrays;

public class InsertArrayElement {

  public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5 };
      int insertElement = 6;
      int insertPosition = 2;

      // create new array with one more element
      int[] newArr = Arrays.copyOf(arr, arr.length + 1);

      // shift elements after the insertion position
      for (int i = newArr.length - 1; i > insertPosition; i--) {
          newArr[i] = newArr[i - 1];
      }

      // insert new element
      newArr[insertPosition] = insertElement;

      // print new array
      System.out.println(Arrays.toString(newArr));
  }
}

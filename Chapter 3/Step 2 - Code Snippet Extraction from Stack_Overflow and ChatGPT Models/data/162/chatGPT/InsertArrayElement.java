
import java.util.Arrays;

public class InsertArrayElement {

  public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5 };
      int insertElement = 6;
      int insertPosition = 2;

      // create new array with one more element
      int[] newArr = new int[arr.length + 1];

      // copy elements up to the insertion position
      for (int i = 0; i < insertPosition; i++) {
          newArr[i] = arr[i];
      }

      // insert new element
      newArr[insertPosition] = insertElement;

      // copy remaining elements
      for (int i = insertPosition + 1; i < newArr.length; i++) {
          newArr[i] = arr[i - 1];
      }

      // print new array
      System.out.println(Arrays.toString(newArr));
  }
}

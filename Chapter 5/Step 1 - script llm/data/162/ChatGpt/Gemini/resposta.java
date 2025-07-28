import java.util.Arrays;

public class InsertArrayElement {

  public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 4, 5 };
      int insertElement = 6;
      int insertPosition = 2;

      // create new array with one more element
      int[] newArr = new int[arr.length + 1];

      // copy elements from original array to new array up to the insertion point
      System.arraycopy(arr, 0, newArr, 0, insertPosition);

      // insert new element
      newArr[insertPosition] = insertElement;

      // copy the remaining elements from the original array to the new array
      System.arraycopy(arr, insertPosition, newArr, insertPosition + 1, arr.length - insertPosition);

      // print new array
      System.out.println(Arrays.toString(newArr));
  }
}

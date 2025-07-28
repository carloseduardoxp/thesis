
import java.util.Arrays;

public class Teste {
  public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        mergeSort(array, leftIndex, middleIndex);
        mergeSort(array, middleIndex + 1, rightIndex);
        merge(array, leftIndex, middleIndex, rightIndex);
    }
  }

  public static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
      int[] leftArray = Arrays.copyOfRange(array, leftIndex, middleIndex + 1);
      int[] rightArray = Arrays.copyOfRange(array, middleIndex + 1, rightIndex + 1);

      int i = 0;
      int j = 0;
      int k = leftIndex;

      while (i < leftArray.length && j < rightArray.length) {
          if (leftArray[i] <= rightArray[j]) {
              array[k] = leftArray[i];
              i++;
          } else {
              array[k] = rightArray[j];
              j++;
          }
          k++;
      }

      while (i < leftArray.length) {
          array[k] = leftArray[i];
          i++;
          k++;
      }

      while (j < rightArray.length) {
          array[k] = rightArray[j];
          j++;
          k++;
      }
  }

}

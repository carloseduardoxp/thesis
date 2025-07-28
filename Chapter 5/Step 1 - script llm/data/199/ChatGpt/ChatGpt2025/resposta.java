import java.util.Arrays;

public class Teste {
  public static void main(String[] args) {
    int[] originalArray = {1, 2, 3};
    int newElement = 4;

    // Create a new array with a larger size and copy the elements
    int[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);

    // Add the new element to the end of the new array
    newArray[newArray.length - 1] = newElement;

    // The newArray now contains the original elements plus the new element

  }
}
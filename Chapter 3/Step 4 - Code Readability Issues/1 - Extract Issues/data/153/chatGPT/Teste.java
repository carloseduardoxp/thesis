public class Teste {
  public static int[] removeDuplicates(int[] sortedArray) {
    int[] result = new int[sortedArray.length];
    int previous = sortedArray[0];
    result[0] = previous;
    for (int i = 1; i < sortedArray.length; i++) {
        int current = sortedArray[i];
        if (current != previous) {
            result[i] = current;
            previous = current;
        }
    }
    return result;
  }

}

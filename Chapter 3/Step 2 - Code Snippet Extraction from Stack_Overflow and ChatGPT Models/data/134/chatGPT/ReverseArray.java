public class ReverseArray {
  public static void main(String[] args) {
      // Create an array of integers
      int[] numbers = {1, 2, 3, 4, 5};

      // Reverse the array
      for (int i = 0; i < numbers.length / 2; i++) {
          int temp = numbers[i];
          numbers[i] = numbers[numbers.length - i - 1];
          numbers[numbers.length - i - 1] = temp;
      }

      // Print the reversed array
      for (int number : numbers) {
          System.out.print(number + " ");
      }
  }
}

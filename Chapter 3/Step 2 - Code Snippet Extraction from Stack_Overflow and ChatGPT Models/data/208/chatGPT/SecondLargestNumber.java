public class SecondLargestNumber {
  public static void main(String[] args) {
      int[] numbers = {5, 10, 8, 20, 15};
      int largest = Integer.MIN_VALUE;
      int secondLargest = Integer.MIN_VALUE;
      for (int number : numbers) {
          if (number > largest) {
              secondLargest = largest;
              largest = number;
          } else if (number > secondLargest && number != largest) {
              secondLargest = number;
          }
      }
      System.out.println("The second largest number is " + secondLargest);
  }
}

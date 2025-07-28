import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array values: ");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();

            if (arr[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];
            } else if (arr[i] > thirdLargest && arr[i] < secondLargest) {
                thirdLargest = arr[i];
            }
        }
        System.out.println("Second Largest number is: " + secondLargest
                + "\nThird largest number is=====" + thirdLargest);
    }
}

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
            if (largest < arr[i]) {
                secondLargest = largest;
                largest = arr[i];
            } else if (secondLargest <= arr[i] && largest > arr[i]) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];
            } else if (thirdLargest <= arr[i] && secondLargest > arr[i]) {
                thirdLargest = arr[i];
            }
        }
        System.out.println("Second Largest number is: " + secondLargest
                + "\nThird largest number is=====" + thirdLargest);
    }
}

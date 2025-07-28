import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        
        if (numbers.length < 2) {
            System.out.println("Array doesn't have enough elements");
            return;
        }
        
        Arrays.sort(numbers);
        int secondLargest = numbers[numbers.length - 2];
        System.out.println("Second largest number is: " + secondLargest);
    }
}

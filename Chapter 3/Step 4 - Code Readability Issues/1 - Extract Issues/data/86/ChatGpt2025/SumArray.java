public class SumArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};  // example array
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum of array elements: " + sum);
    }
}

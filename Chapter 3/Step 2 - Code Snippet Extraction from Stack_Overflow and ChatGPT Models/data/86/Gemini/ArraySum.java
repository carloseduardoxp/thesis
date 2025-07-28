public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;

        // Iterate through the array using a traditional for loop
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // Add each element to sum
        }

        System.out.println("The sum of the array elements is: " + sum); // Output: 150
    }
}

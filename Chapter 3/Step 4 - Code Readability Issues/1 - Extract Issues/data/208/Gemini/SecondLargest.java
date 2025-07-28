import java.util.Arrays;

public class SecondLargest {

    public static int findSecondLargestUsingSorting(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array is too small or null to find a second largest element.");
            return -1; // Or throw an IllegalArgumentException
        }

        Arrays.sort(arr);

        // Iterate from the second-to-last element backwards to handle duplicates
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }
        System.out.println("All elements are the same.");
        return -1; // All elements are the same
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 20, 8, 15};
        System.out.println("Second largest in arr1: " + findSecondLargestUsingSorting(arr1)); // Expected: 15

        int[] arr2 = {5, 5, 5, 5};
        System.out.println("Second largest in arr2: " + findSecondLargestUsingSorting(arr2)); // Expected: -1 (All same)

        int[] arr3 = {7, 7, 10, 10, 10};
        System.out.println("Second largest in arr3: " + findSecondLargestUsingSorting(arr3)); // Expected: 7

        int[] arr4 = {10};
        System.out.println("Second largest in arr4: " + findSecondLargestUsingSorting(arr4)); // Expected: -1 (Too small)

        int[] arr5 = {1, 2};
        System.out.println("Second largest in arr5: " + findSecondLargestUsingSorting(arr5)); // Expected: 1
    }
}

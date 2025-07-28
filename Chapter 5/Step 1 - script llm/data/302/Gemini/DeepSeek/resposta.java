import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted or empty
        }
        int[] temp = new int[arr.length]; // Temporary array for merging
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle point
            mergeSort(arr, temp, left, mid);      // Sort the first half
            mergeSort(arr, temp, mid + 1, right); // Sort the second half
            merge(arr, temp, left, mid, right);   // Merge the sorted halves
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left;      // Pointer for the first half
        int j = mid + 1;   // Pointer for the second half
        int k = left;      // Pointer for the original array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};
        System.out.println("Original Array:");
        printArray(data);

        mergeSort(data);

        System.out.println("Sorted Array (Merge Sort):");
        printArray(data);

        int[] data2 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("\nOriginal Array 2:");
        printArray(data2);
        mergeSort(data2);
        System.out.println("Sorted Array 2 (Merge Sort):");
        printArray(data2);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

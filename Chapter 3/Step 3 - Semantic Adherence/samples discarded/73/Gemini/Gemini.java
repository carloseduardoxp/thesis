import java.util.Arrays;

public class ArrayRemoveByValue {

    public static int[] removeElementByValue(int[] originalArray, int elementToRemove) {
        // Count occurrences to determine the size of the new array
        int count = 0;
        for (int x : originalArray) {
            if (x == elementToRemove) {
                count++;
            }
        }

        // If the element isn't found, return the original array
        if (count == 0) {
            return originalArray;
        }

        int[] newArray = new int[originalArray.length - count];
        int newArrayIndex = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != elementToRemove) {
                newArray[newArrayIndex] = originalArray[i];
                newArrayIndex++;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 20, 40, 50};
        int elementToRemove = 20;

        System.out.println("Original array: " + Arrays.toString(numbers));

        int[] modifiedNumbers = removeElementByValue(numbers, elementToRemove);
        System.out.println("Array after removing " + elementToRemove + ": " + Arrays.toString(modifiedNumbers));

        int[] numbers2 = {1, 2, 3};
        int elementToRemove2 = 5;
        int[] modifiedNumbers2 = removeElementByValue(numbers2, elementToRemove2);
        System.out.println("Array after trying to remove " + elementToRemove2 + " (not present): " + Arrays.toString(modifiedNumbers2));
    }
}

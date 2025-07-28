import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int elementToRemove = 3;

        int[] newArray = removeElement(originalArray, elementToRemove);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("New Array after removing " + elementToRemove + ": " + Arrays.toString(newArray));
    }

    public static int[] removeElement(int[] arr, int element) {
        int count = 0;
        for (int value : arr) {
            if (value != element) {
                count++;
            }
        }

        int[] newArray = new int[count];
        int index = 0;
        for (int value : arr) {
            if (value != element) {
                newArray[index++] = value;
            }
        }
        return newArray;
    }
}

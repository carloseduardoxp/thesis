public class Example {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int removeIndex = 2;

        // Create a new array with size one less than the original array
        int[] newArr = new int[arr.length - 1];

        // Copy the elements before the index to the new array
        for (int i = 0; i < removeIndex; i++) {
            newArr[i] = arr[i];
        }

        // Copy the elements after the index to the new array
        for (int i = removeIndex + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        // Print the new array
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }


    }
}

public class DeepSeek {

    public static void main(String[] args) {
        // Usage:
        int[] array = {1, 2, 3, 4, 5};
        insertElement(array, 99, 2); // Insert 99 at position 2
    }

    public static int[] insertElement(int[] originalArray, int element, int position) {
        if (position < 0 || position > originalArray.length) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        int[] newArray = new int[originalArray.length + 1];

        // Copy elements before the insertion point
        System.arraycopy(originalArray, 0, newArray, 0, position);

        // Insert the new element
        newArray[position] = element;

        // Copy elements after the insertion point
        System.arraycopy(originalArray, position, newArray, position + 1, originalArray.length - position);

        return newArray;
    }

}
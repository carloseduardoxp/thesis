public class DeepSeek {

    public static void main(String[] args) {

        int[] originalArray = {1, 2, 3};
        int newElement = 4;

        // Create new array with larger size
        int[] newArray = new int[originalArray.length + 1];

        // Copy original elements
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        // Add new element at the end
        newArray[newArray.length - 1] = newElement;

    }

}
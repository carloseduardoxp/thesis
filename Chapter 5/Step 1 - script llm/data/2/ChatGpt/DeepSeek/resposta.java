public class Teste {

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int elementToRemove = 3;
        int index = -1;

        // Find the index of the element to remove
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == elementToRemove) {
                index = i;
                break;
            }
        }

        // Create a new array with one less element
        int[] newArray = new int[originalArray.length - 1];

        // Copy all the elements of the original array into the new array
        int newIndex = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (i != index) {
                newArray[newIndex] = originalArray[i];
                newIndex++;
            }
        }

        // The element has been removed from the array
    }
}
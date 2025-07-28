
public class Teste {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3, 4, 5};

        // Create a new array with a larger size
        int[] newArray = new int[oldArray.length + 1];

        // Copy the elements from the old array to the new array
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        // Add a new element to the end of the new array
        newArray[newArray.length - 1] = 6;

    }
}

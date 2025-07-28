import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3, 4, 5};

        // Create a new array with a larger size and copy the elements
        int[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);

        // Add a new element to the end of the new array
        newArray[newArray.length - 1] = 6;

    }
}

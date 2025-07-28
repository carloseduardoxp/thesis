import java.util.Arrays;

public class ArrayExtensionExample {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3};
        int[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
        newArray[newArray.length - 1] = 4; // add element to the end of the array
        System.out.println(Arrays.toString(newArray)); // Output: [1, 2, 3, 4]
    }
}

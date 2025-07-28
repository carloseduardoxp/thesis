import java.util.Arrays;

public class Gemini {
    public static void main(String[] args) {
        String[] myArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Original array: " + Arrays.toString(myArray));

        if (myArray.length > 0) {
            String[] newArray = Arrays.copyOf(myArray, myArray.length - 1);
            String poppedElement = myArray[myArray.length - 1];
            myArray = newArray; // Update the original reference
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Array after pop: " + Arrays.toString(myArray));
        } else {
            System.out.println("Array is empty, cannot pop.");
        }
    }
}

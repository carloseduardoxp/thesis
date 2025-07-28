
public class DeepSeek {

    public static void main(String[] args) {

        int[] originalArray = {1, 2, 3};
        int[] newArray = new int[originalArray.length + 1]; // extend by 1

// Copy elements from original to new array
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

// Add new element
        newArray[newArray.length - 1] = 4;

    }

}

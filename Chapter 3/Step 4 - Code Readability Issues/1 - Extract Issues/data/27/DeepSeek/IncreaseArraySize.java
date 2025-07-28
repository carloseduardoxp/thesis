public class IncreaseArraySize {
    public static void main(String[] args) {
        // Original array
        int[] originalArray = {1, 2, 3, 4, 5};
        
        // New size (e.g., double the original size)
        int newSize = originalArray.length * 2;
        
        // Create a new array with the new size
        int[] newArray = new int[newSize];
        
        // Copy elements from the original array to the new array
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        
        // Optionally, assign the new array to the original reference
        originalArray = newArray;
        
        // Verify the new size
        System.out.println("New array length: " + originalArray.length); // Output: 10
    }
}

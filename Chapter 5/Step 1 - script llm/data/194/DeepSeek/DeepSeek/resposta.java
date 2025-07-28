public class DeepSeek {

    public static void main(String[] args) {

        int[] array = new int[10]; // Array with capacity for 10 elements
        int size = 0; // Tracks how many elements are actually populated

        // Insert at the end
        array[size++] = 5; 
        array[size++] = 10;

        // Insert at specific position (index 1)
        int insertIndex = 1;
        int newValue = 7;

        // Shift elements to the right
        for (int i = size; i > insertIndex; i--) {
            array[i] = array[i-1];
        }
        array[insertIndex] = newValue;
        size++;

    }

}

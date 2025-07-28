public class AddToEndOfArray {

    public static void main(String[] args) {
        String[] originalArray = {"apple", "banana", "cherry"};
        String newItem = "date";

        // 1. Create a new array with one more space
        String[] newArray = new String[originalArray.length + 1];

        // 2. Copy elements from the original array to the new array
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        // 3. Add the new item to the end of the new array
        newArray[newArray.length - 1] = newItem;

        // Print the new array to verify
        System.out.println("Original Array:");
        for (String s : originalArray) {
            System.out.print(s + " ");
        }
        System.out.println("\nNew Array:");
        for (String s : newArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

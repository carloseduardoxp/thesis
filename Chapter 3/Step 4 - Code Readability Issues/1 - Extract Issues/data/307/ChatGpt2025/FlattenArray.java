public class FlattenArray {
    public static void main(String[] args) {
        int[][] multiArray = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };

        // Calculate total length for the flattened array
        int totalLength = 0;
        for (int[] arr : multiArray) {
            totalLength += arr.length;
        }

        // Create the flattened array
        int[] flatArray = new int[totalLength];

        // Copy elements into the flat array
        int index = 0;
        for (int[] arr : multiArray) {
            for (int num : arr) {
                flatArray[index++] = num;
            }
        }

        // Print the flattened array
        for (int num : flatArray) {
            System.out.print(num + " ");
        }
    }
}

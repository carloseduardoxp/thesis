public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] destinationArray = new int[sourceArray.length];

        // System.arraycopy(source, sourceStartIndex, destination, destinationStartIndex, length)
        System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);

        System.out.println("Source Array: ");
        for (int i : sourceArray) {
            System.out.print(i + " ");
        }
        System.out.println("\nDestination Array (copied): ");
        for (int i : destinationArray) {
            System.out.print(i + " ");
        }

        // Prove they are independent:
        sourceArray[0] = 99;
        System.out.println("\n\nAfter modifying sourceArray[0]:");
        System.out.println("Source Array: " + sourceArray[0]);
        System.out.println("Destination Array: " + destinationArray[0]); // destinationArray[0] remains 1
    }
}

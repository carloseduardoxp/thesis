public class ArrayLengthExample {
    public static void main(String[] args) {
        // For primitive arrays
        int[] intArray = {1, 2, 3, 4, 5};
        int intLength = intArray.length;
        System.out.println("Length of intArray: " + intLength); // Output: 5

        // For Object arrays
        String[] stringArray = {"apple", "banana", "cherry"};
        int stringLength = stringArray.length;
        System.out.println("Length of stringArray: " + stringLength); // Output: 3

        // For an empty array
        double[] emptyArray = new double[0];
        int emptyLength = emptyArray.length;
        System.out.println("Length of emptyArray: " + emptyLength); // Output: 0
    }
}

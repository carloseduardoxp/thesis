public class IntCasting {
    public static void main(String[] args) {
        // Casting a long to an int
        long myLong = 123456789123L;
        int intFromLong = (int) myLong; // Explicit cast
        System.out.println("Long: " + myLong + ", Int from Long: " + intFromLong);
        // Note: If myLong is larger than Integer.MAX_VALUE or smaller than Integer.MIN_VALUE,
        // the int will overflow/underflow, resulting in a different value.
        // Example of overflow:
        long largeLong = 3000000000L; // Larger than Integer.MAX_VALUE
        int overflowInt = (int) largeLong;
        System.out.println("Large Long: " + largeLong + ", Int from large Long (overflow): " + overflowInt);


        // Casting a float to an int
        float myFloat = 3.14159f;
        int intFromFloat = (int) myFloat; // Explicit cast (discards decimal part)
        System.out.println("Float: " + myFloat + ", Int from Float: " + intFromFloat);

        // Casting a double to an int
        double myDouble = 98.7654321;
        int intFromDouble = (int) myDouble; // Explicit cast (discards decimal part)
        System.out.println("Double: " + myDouble + ", Int from Double: " + intFromDouble);
    }
}

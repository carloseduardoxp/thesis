public class SwapNumbers {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Before swapping (XOR): a = " + a + ", b = " + b);

        a = a ^ b; // a now holds the XOR sum of original a and b
        b = a ^ b; // b now becomes original a (a^b^b = a)
        a = a ^ b; // a now becomes original b (a^b^a = b)

        System.out.println("After swapping (XOR): a = " + a + ", b = " + b);
    }
}

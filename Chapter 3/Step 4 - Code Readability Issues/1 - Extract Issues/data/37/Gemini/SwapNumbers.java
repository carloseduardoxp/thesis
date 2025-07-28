public class SwapNumbers {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        // Swap using addition and subtraction
        a = a + b; // a now holds the sum of original a and b
        b = a - b; // b now holds the original value of a (sum - original b)
        a = a - b; // a now holds the original value of b (sum - original a)

        System.out.println("After swapping: a = " + a + ", b = " + b);

        int x = 15;
        int y = 20;

        System.out.println("\nBefore swapping: x = " + x + ", y = " + y);

        // Swap using multiplication and division (be cautious with zero)
        x = x * y; // x now holds the product of original x and y
        y = x / y; // y now holds the original value of x (product / original y)
        x = x / y; // x now holds the original value of y (product / original x)

        System.out.println("After swapping: x = " + x + ", y = " + y);

        int p = 7;
        int q = 3;

        System.out.println("\nBefore swapping: p = " + p + ", q = " + q);

        // Swap using bitwise XOR
        p = p ^ q; // p now holds the XOR of original p and q
        q = p ^ q; // q now holds the original value of p (XOR of (p^q) and q)
        p = p ^ q; // p now holds the original value of q (XOR of (p^q) and original p)

        System.out.println("After swapping: p = " + p + ", q = " + q);
    }
}

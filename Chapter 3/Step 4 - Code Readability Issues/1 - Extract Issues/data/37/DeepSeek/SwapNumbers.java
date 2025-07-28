public class SwapNumbers {
    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        System.out.println("Before swap: a = " + a + ", b = " + b);

        a = a + b;  // a becomes 15 (5 + 10)
        b = a - b;  // b becomes 5 (15 - 10)
        a = a - b;  // a becomes 10 (15 - 5)

        System.out.println("After swap: a = " + a + ", b = " + b);

    }
}
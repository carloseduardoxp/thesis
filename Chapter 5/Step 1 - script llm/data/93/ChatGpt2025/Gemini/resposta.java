public class Fibonacci {
    public static void main(String[] args) {
        int n = 10; // Number of terms to display
        int a = 0;
        int b = 1;

        System.out.print("Fibonacci sequence: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }
}

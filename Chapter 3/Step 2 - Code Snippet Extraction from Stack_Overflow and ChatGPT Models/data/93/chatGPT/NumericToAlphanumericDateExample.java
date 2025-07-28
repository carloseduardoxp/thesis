public class NumericToAlphanumericDateExample {
    public static void main(String[] args) {
        fibonacci(10);
    }

    public static void fibonacci(int n) {
        int prev1 = 0;
        int prev2 = 1;
    
        System.out.print(prev1 + " " + prev2);
    
        for (int i = 2; i < n; i++) {
            int next = prev1 + prev2;
            System.out.print(" " + next);
            prev1 = prev2;
            prev2 = next;
        }
    }
    
}

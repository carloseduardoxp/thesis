public class LoopBreakExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current value of i: " + i);
            if (i == 5) {
                System.out.println("Condition met! Breaking out of the loop.");
                break; // Exits the for loop
            }
        }
        System.out.println("Loop finished.");
    }
}

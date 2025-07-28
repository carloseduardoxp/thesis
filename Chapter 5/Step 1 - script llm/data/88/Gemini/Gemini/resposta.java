public class TowersOfHanoi {

    /**
     * Solves the Towers of Hanoi puzzle for a given number of disks.
     *
     * @param n The number of disks to move.
     * @param source The name of the source peg.
     * @param auxiliary The name of the auxiliary (helper) peg.
     * @param destination The name of the destination peg.
     */
    public void solveHanoi(int n, String source, String auxiliary, String destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary, using destination as helper
        String auxiliaryForStep1 = destination;
        String destinationForStep1 = auxiliary;
        solveHanoi(n - 1, source, auxiliaryForStep1, destinationForStep1);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination, using source as helper
        String sourceForStep3 = auxiliary;
        String auxiliaryForStep3 = source;
        solveHanoi(n - 1, sourceForStep3, auxiliaryForStep3, destination);
    }

    public static void main(String[] args) {
        TowersOfHanoi hanoi = new TowersOfHanoi();
        int numberOfDisks = 3; // You can change this to test with different numbers of disks

        System.out.println("Towers of Hanoi with " + numberOfDisks + " disks:");
        hanoi.solveHanoi(numberOfDisks, "A", "B", "C");
    }
}

public class TowersOfHanoi {

    public static void main(String[] args) {
        int numberOfDisks = 3; // You can change this value
        solveHanoi(numberOfDisks, 'A', 'C', 'B');
    }

    /**
     * Solves the Towers of Hanoi problem recursively
     * @param n Number of disks to move
     * @param fromRod The starting rod
     * @param toRod The destination rod
     * @param auxRod The auxiliary rod
     */
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        
        // Move top n-1 disks from fromRod to auxRod, using toRod as auxiliary
        char destinationForSubproblem = auxRod;
        solveHanoi(n - 1, fromRod, destinationForSubproblem, toRod);
        
        // Move the remaining disk from fromRod to toRod
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        
        // Move the n-1 disks from auxRod to toRod, using fromRod as auxiliary
        char sourceForSubproblem = auxRod;
        solveHanoi(n - 1, sourceForSubproblem, toRod, fromRod);
    }
}

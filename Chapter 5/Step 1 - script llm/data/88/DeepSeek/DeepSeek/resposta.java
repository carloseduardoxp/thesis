public class TowersOfHanoi {

    public static void main(String[] args) {
        int numberOfDisks = 3; // You can change this value
        solveHanoi(numberOfDisks, 'A', 'B', 'C');
    }

    /**
     * Solves the Towers of Hanoi problem recursively
     * @param n Number of disks to move
     * @param sourceRod The starting rod
     * @param auxiliaryRod The auxiliary rod
     * @param destinationRod The destination rod
     */
    public static void solveHanoi(int n, char sourceRod, char auxiliaryRod, char destinationRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + sourceRod + " to rod " + destinationRod);
            return;
        }
        
        // Move top n-1 disks from sourceRod to auxiliaryRod, using destinationRod as auxiliary
        solveHanoi(n - 1, sourceRod, destinationRod, auxiliaryRod);
        
        // Move the remaining disk from sourceRod to destinationRod
        System.out.println("Move disk " + n + " from rod " + sourceRod + " to rod " + destinationRod);
        
        // Move the n-1 disks from auxiliaryRod to destinationRod, using sourceRod as auxiliary
        solveHanoi(n - 1, auxiliaryRod, sourceRod, destinationRod);
    }
}

public class TowersOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char from = 'A';
        char to = 'C';
        char aux = 'B'; // Pegs
        
        System.out.println("Moves:");
        moveDisks(n, from, to, aux);
    }
    
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println(source + " -> " + destination);
        } else {
            moveDisks(n-1, source, auxiliary, destination);
            System.out.println(source + " -> " + destination);
            moveDisks(n-1, auxiliary, destination, source);
        }
    }
}

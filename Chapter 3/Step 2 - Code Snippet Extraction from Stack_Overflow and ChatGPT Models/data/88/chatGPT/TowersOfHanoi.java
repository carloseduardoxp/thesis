public class TowersOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char from = 'A', to = 'C', aux = 'B'; // Pegs
        
        System.out.println("Moves:");
        moveDisks(n, from, to, aux);
    }
    
    public static void moveDisks(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println(from + " -> " + to);
        } else {
            moveDisks(n-1, from, aux, to);
            System.out.println(from + " -> " + to);
            moveDisks(n-1, aux, to, from);
        }
    }
}

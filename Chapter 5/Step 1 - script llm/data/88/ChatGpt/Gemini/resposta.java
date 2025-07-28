public class TowersOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char from = 'A'; // Pegs
        char to = 'C';
        char aux = 'B';
        
        System.out.println("Moves:");
        moveDisks(n, from, to, aux);
    }
    
    public static void moveDisks(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println(from + " -> " + to);
        } else {
            char firstCallTo = aux;
            char firstCallAux = to;
            moveDisks(n - 1, from, firstCallTo, firstCallAux);
            
            System.out.println(from + " -> " + to);
            
            char secondCallFrom = aux;
            char secondCallAux = from;
            moveDisks(n - 1, secondCallFrom, to, secondCallAux);
        }
    }
}

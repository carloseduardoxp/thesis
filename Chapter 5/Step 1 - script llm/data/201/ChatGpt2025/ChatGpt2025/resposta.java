class Globals {
    public static final int globalCounter = 0;
}
public class TestGlobal {
    public static void main(String[] args) {
        // Accessing the global variable
        System.out.println("Counter: " + Globals.globalCounter);
        // Globals.globalCounter++; // Cannot increment final variable
        System.out.println("Counter after increment: " + Globals.globalCounter);
    }
}
class Globals {
    private static int globalCounter = 0;

    private Globals() {
        // Private constructor to prevent instantiation
    }

    public static int getGlobalCounter() {
        return globalCounter;
    }

    public static void incrementGlobalCounter() {
        globalCounter++;
    }
}
public class TestGlobal {
    public static void main(String[] args) {
        // Accessing and modifying the encapsulated global variable
        System.out.println("Counter: " + Globals.getGlobalCounter());
        Globals.incrementGlobalCounter();
        System.out.println("Counter after increment: " + Globals.getGlobalCounter());
    }
}

class Globals {
    public static int globalCounter = 0;
}
public class TestGlobal {
    public static void main(String[] args) {
        // Accessing and modifying the global variable
        System.out.println("Counter: " + Globals.globalCounter);
        Globals.globalCounter++;
        System.out.println("Counter after increment: " + Globals.globalCounter);
    }
}

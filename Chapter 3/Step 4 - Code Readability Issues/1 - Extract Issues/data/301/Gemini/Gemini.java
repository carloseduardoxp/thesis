public class MyJavaApp {
    public static void main(String[] args) {
        System.out.println("Application starting...");

        // ... your application logic ...

        // To terminate the JVM
        System.exit(0); // 0 typically indicates successful termination
        // System.exit(1); // Non-zero indicates an error or abnormal termination

        // Any code after System.exit() will not be executed
        System.out.println("This will not be printed.");
    }
}

public class MyGlobalVariables {

    // Public static variable (accessible from anywhere)
    public static int globalCounter = 0;

    // Public static final variable (constant, accessible from anywhere)
    public static final String APP_NAME = "My Awesome App";

    // Private static variable (accessible only within this class,
    // but can be accessed via a public static getter if needed)
    private static double PI_VALUE = 3.14159;

    public static double getPiValue() {
        return PI_VALUE;
    }

    public void incrementCounter() {
        globalCounter++;
    }

    public static void main(String[] args) {
        // Accessing static variables directly using the class name
        System.out.println("App Name: " + MyGlobalVariables.APP_NAME);
        System.out.println("Initial Counter: " + MyGlobalVariables.globalCounter);

        MyGlobalVariables obj1 = new MyGlobalVariables();
        MyGlobalVariables obj2 = new MyGlobalVariables();

        obj1.incrementCounter();
        obj2.incrementCounter();

        System.out.println("Counter after increments: " + MyGlobalVariables.globalCounter); // Output will be 2

        System.out.println("PI Value: " + MyGlobalVariables.getPiValue());
    }
}

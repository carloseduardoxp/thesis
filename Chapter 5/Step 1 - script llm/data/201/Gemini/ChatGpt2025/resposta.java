public class MyGlobalVariables {

    // Public static final variable (constant, accessible from anywhere)
    public static final int GLOBAL_COUNTER = 0;

    // Public static final variable (constant, accessible from anywhere)
    public static final String APP_NAME = "My Awesome App";

    // Private static variable (accessible only within this class,
    // but can be accessed via a public static getter if needed)
    private static double piValue = 3.14159;

    public static double getPiValue() {
        return piValue;
    }

    public void incrementCounter() {
        // GLOBAL_COUNTER is final and cannot be incremented
        // This method should be removed or refactored if mutability is required
    }

    public static void main(String[] args) {
        // Accessing static variables directly using the class name
        System.out.println("App Name: " + MyGlobalVariables.APP_NAME);
        System.out.println("Initial Counter: " + MyGlobalVariables.GLOBAL_COUNTER);

        MyGlobalVariables obj1 = new MyGlobalVariables();
        MyGlobalVariables obj2 = new MyGlobalVariables();

        obj1.incrementCounter();
        obj2.incrementCounter();

        System.out.println("Counter after increments: " + MyGlobalVariables.GLOBAL_COUNTER); // Output will be 0

        System.out.println("PI Value: " + MyGlobalVariables.getPiValue());
    }
}
public class MyGlobalVariables {

    // Made private to prevent direct modification from outside the class.
    private static int globalCounter = 0;

    // Public static final variable (constant, accessible from anywhere)
    public static final String APP_NAME = "My Awesome App";

    // Made final as it represents a constant, which also resolves the naming convention issue.
    private static final double PI_VALUE = 3.14159;

    public static double getPiValue() {
        return PI_VALUE;
    }

    public static int getGlobalCounter() {
        return globalCounter;
    }

    public void incrementCounter() {
        globalCounter++;
    }

    public static void main(String[] args) {
        // Accessing static variables directly using the class name
        System.out.println("App Name: " + MyGlobalVariables.APP_NAME);
        // Accessing the counter via its public getter
        System.out.println("Initial Counter: " + MyGlobalVariables.getGlobalCounter());

        MyGlobalVariables obj1 = new MyGlobalVariables();
        MyGlobalVariables obj2 = new MyGlobalVariables();

        obj1.incrementCounter();
        obj2.incrementCounter();

        // Accessing the counter via its public getter
        System.out.println("Counter after increments: " + MyGlobalVariables.getGlobalCounter()); // Output will be 2

        System.out.println("PI Value: " + MyGlobalVariables.getPiValue());
    }
}

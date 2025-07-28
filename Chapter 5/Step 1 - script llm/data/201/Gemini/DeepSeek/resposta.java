public class MyGlobalVariables {

    // Public static final variable (constant, accessible from anywhere)
    public static final String APP_NAME = "My Awesome App";

    // Private static variable (accessible only within this class,
    // but can be accessed via a public static getter if needed)
    private static double piValue = 3.14159;

    public static double getPiValue() {
        return piValue;
    }

    public static void main(String[] args) {
        // Accessing static variables directly using the class name
        System.out.println("App Name: " + MyGlobalVariables.APP_NAME);

        System.out.println("PI Value: " + MyGlobalVariables.getPiValue());
    }
}

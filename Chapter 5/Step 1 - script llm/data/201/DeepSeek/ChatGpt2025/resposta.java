class GlobalVars {
    public static final int globalCount = 0;
    public static final String appName = "MyApp";
}
public class Main {
    public static void main(String[] args) {
        // GlobalVars.globalCount = 10; // This line would now cause a compilation error
        System.out.println(GlobalVars.appName); // Output: MyApp
    }
}
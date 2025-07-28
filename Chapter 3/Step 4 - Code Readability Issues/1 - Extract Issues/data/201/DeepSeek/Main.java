class GlobalVars {
    public static int globalCount = 0;
    public static String appName = "MyApp";
}
public class Main {
    public static void main(String[] args) {
        GlobalVars.globalCount = 10;
        System.out.println(GlobalVars.appName); // Output: MyApp
    }
}

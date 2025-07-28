
public class DeepSeek {

    public static void main(String[] args) {

        Process process = Runtime.getRuntime().exec("your-command");
// ... later when you want to kill it
        process.destroy(); // Forceful termination
// or
        process.destroyForcibly(); // Even more forceful (Java 8+)

    }

}

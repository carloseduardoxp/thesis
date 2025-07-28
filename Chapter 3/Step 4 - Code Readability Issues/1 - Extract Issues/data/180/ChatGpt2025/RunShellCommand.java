import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunShellCommand {
    public static void main(String[] args) {
        try {
            // Command to run (example: list files in current directory)
            String command = "ls -l";

            // Run the command
            Process process = Runtime.getRuntime().exec(command);

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the command to complete and get exit status
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

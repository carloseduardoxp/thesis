
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DeepSeek {

    public static void main(String[] args) {

        try {
            // Execute a simple command
            Process process = Runtime.getRuntime().exec("ls -l");

            // Read the output
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the command to complete
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

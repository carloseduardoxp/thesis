import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LinuxCommandExecutor {

    public static void main(String[] args) {
        // Example 1: Listing files in a directory
        executeCommand("ls", "-l");

        System.out.println("\n--- Executing a command with arguments ---");
        // Example 2: Ping google.com 3 times
        executeCommand("ping", "-c", "3", "google.com");

        System.out.println("\n--- Executing a shell command (e.g., with pipes) ---");
        // Example 3: Using a shell command with a pipe
        // Note: For complex shell commands, you need to explicitly invoke the shell
        executeCommand("/bin/bash", "-c", "ps aux | grep java");

        System.out.println("\n--- Executing a command in a specific directory ---");
        // Example 4: Listing files in /tmp
        executeCommandInDirectory("ls", "-l", "/tmp");
    }

    public static void executeCommand(String... command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read the error output (important for debugging)
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + line);
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Command exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeCommandInDirectory(String command, String args, String directoryPath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command, args);
            processBuilder.directory(new java.io.File(directoryPath)); // Set the working directory

            Process process = processBuilder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read the error output
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("Command exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

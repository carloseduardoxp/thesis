import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellCommandExample {

  public static void main(String[] args) {

    String command = "ls -la"; // Replace with your command

    try {
      // Execute the command
      Process process = Runtime.getRuntime().exec(command);

      // Read the output of the command
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      // Wait for the command to complete
      int exitCode = process.waitFor();
      System.out.println("Command exited with code " + exitCode);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

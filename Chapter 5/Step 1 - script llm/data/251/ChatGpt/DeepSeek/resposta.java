import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyApp {
    public static void main(String[] args) throws IOException {
        // Read the configuration file path from the command-line arguments
        if (args.length == 0) {
            System.out.println("Usage: MyApp <config-file>");
            System.exit(1);
        }
        String configFile = args[0];

        // Load the configuration file
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(configFile);
        props.load(in);
        in.close();

        // Use the configuration properties
        props.getProperty("database.url");
        props.getProperty("database.user");
        props.getProperty("database.password");

        // ...
    }
}

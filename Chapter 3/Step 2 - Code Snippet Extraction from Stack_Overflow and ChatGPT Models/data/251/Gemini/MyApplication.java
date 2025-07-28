import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyApplication {

    private static final Properties config = new Properties();
    private static final String CONFIG_FILE_NAME = "config.properties"; // Or "config/config.properties"

    public static void main(String[] args) {
        loadConfig();
        
        // Now you can access your configuration properties
        System.out.println("Application Name: " + config.getProperty("appName"));
        System.out.println("DB URL: " + config.getProperty("db.url"));
        System.out.println("Debug Mode: " + Boolean.parseBoolean(config.getProperty("debugMode", "false"))); // Default value if not found

        // Example of using a property
        if (Boolean.parseBoolean(config.getProperty("debugMode"))) {
            System.out.println("Running in debug mode.");
        }

        // ... rest of your application logic
    }

    private static void loadConfig() {
        try {
            // Option 1: Load from file system (recommended for external config)
            // This looks for the config file relative to where the JVM was launched,
            // or relative to your JAR file if launched with `java -jar yourapp.jar`.
            InputStream input = new FileInputStream(CONFIG_FILE_NAME);
            config.load(input);
            System.out.println("Configuration loaded from " + CONFIG_FILE_NAME);

            // Option 2: Load from classpath (if config.properties is inside your JAR in src/main/resources)
            /*
            InputStream input = MyApplication.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            if (input == null) {
                System.err.println("Sorry, unable to find " + CONFIG_FILE_NAME + " in the classpath.");
                return;
            }
            config.load(input);
            System.out.println("Configuration loaded from classpath: " + CONFIG_FILE_NAME);
            */

        } catch (IOException ex) {
            System.err.println("Error loading configuration: " + ex.getMessage());
            // Handle this error appropriately, e.g., exit the application or use default values.
            // For production, you might want to log this extensively.
            System.exit(1); // Exit if config is crucial
        }
    }

    // Helper method to get properties safely
    public static String getConfigProperty(String key) {
        return config.getProperty(key);
    }

    public static String getConfigProperty(String key, String defaultValue) {
        return config.getProperty(key, defaultValue);
    }
    
    public static boolean getBooleanConfigProperty(String key, boolean defaultValue) {
        String value = config.getProperty(key);
        if (value != null) {
            return Boolean.parseBoolean(value);
        }
        return defaultValue;
    }
}

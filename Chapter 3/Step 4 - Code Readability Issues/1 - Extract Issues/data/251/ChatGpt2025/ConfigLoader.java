import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader(String configFilePath) {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(configFilePath)) {
            // Load properties from the file
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Failed to load configuration file: " + e.getMessage());
        }
    }

    // Method to get a property by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Method to get a property as a boolean
    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    // Method to get a property as an integer
    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key, "0"));
    }

    public static void main(String[] args) {
        // Initialize the config loader with the path to the config file
        ConfigLoader configLoader = new ConfigLoader("config.properties");

        // Access properties
        String appName = configLoader.getProperty("app.name");
        String appVersion = configLoader.getProperty("app.version");
        boolean isDebugMode = configLoader.getBooleanProperty("app.debug");

        // Use the loaded properties
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
        System.out.println("Is Debug Mode: " + isDebugMode);
    }
}

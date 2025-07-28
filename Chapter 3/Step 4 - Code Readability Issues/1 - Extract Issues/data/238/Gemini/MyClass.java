import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyClass {

    public static void main(String[] args) {
        Properties props = new Properties();
        // The file is at the root of the classpath, so we use a leading slash.
        // If it were in resources/configs/config.properties, it would be "/configs/config.properties"
        try (InputStream input = MyClass.class.getResourceAsStream("/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            props.load(input);
            System.out.println("App Name: " + props.getProperty("app.name"));
            System.out.println("Version: " + props.getProperty("app.version"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

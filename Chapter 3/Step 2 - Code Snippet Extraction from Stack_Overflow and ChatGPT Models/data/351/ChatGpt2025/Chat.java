
import java.io.*;
import java.util.Properties;


public class Chat {

    public static void main(String[] args) {

        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties props = new Properties();
        if (input != null) {
            props.load(input);
            System.out.println(props.getProperty("some.key"));
        } else {
            throw new FileNotFoundException("Resource not found");
        }

    }

}

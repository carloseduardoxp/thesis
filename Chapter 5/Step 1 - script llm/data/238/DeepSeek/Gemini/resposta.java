import java.io.*;


public class DeepSeek {

    public static void main(String[] args) {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("path/to/file.txt");

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.err.println("File not found in classpath");
        }

    }

}

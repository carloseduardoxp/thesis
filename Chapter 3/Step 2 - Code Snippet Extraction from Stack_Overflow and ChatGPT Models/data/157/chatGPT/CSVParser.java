import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {

    public static void main(String[] args) {

        String csvFile = "example.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] values = line.split(cvsSplitBy);

                // process the values as needed
                System.out.println("Value 1: " + values[0] + " Value 2: " + values[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

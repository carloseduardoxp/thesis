import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvParser {
    public static void main(String[] args) {
        String fileName = "data.csv";
        
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            List<String[]> records = csvReader.readAll();
            
            for (String[] record : records) {
                for (String field : record) {
                    System.out.print(field + " | ");
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
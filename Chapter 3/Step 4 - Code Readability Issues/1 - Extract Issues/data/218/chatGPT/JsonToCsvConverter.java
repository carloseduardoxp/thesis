import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonToCsvConverter {

    public static void main(String[] args) {
        String jsonFilePath = "path/to/json/file.json";
        String csvFilePath = "path/to/csv/file.csv";
        convertJsonToCsv(jsonFilePath, csvFilePath);
    }

    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            // Parse JSON file
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(new FileReader(jsonFilePath));

            // Write CSV file
            CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(csvFilePath)));

            List<String> headers = new ArrayList<String>();
            List<String[]> rows = new ArrayList<String[]>();
            boolean headerWritten = false;

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();

                if (!headerWritten) {
                    headers.add(fieldName);
                }

                if (jsonParser.nextToken() == JsonToken.START_ARRAY) {
                    Iterator<JsonToken> arrayIterator = jsonParser.getCodec().readValues(jsonParser, JsonToken.class);

                    while (arrayIterator.hasNext()) {
                        List<String> row = new ArrayList<String>();
                        JsonToken token = arrayIterator.next();

                        while (token != JsonToken.END_ARRAY) {
                            String value = jsonParser.getText();
                            row.add(value);
                            token = arrayIterator.next();
                        }

                        rows.add(row.toArray(new String[row.size()]));
                    }
                }

                headerWritten = true;
            }

            csvWriter.writeNext(headers.toArray(new String[headers.size()]));
            csvWriter.writeAll(rows);

            csvWriter.close();
            jsonParser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class JsonToCsvConverter {
    public static void convertJsonToCsv(String jsonInput, String csvOutputPath) throws IOException {
        // Create Jackson mappers
        ObjectMapper jsonMapper = new ObjectMapper();
        CsvMapper csvMapper = new CsvMapper();
        
        // Read JSON data
        JsonNode jsonTree = jsonMapper.readTree(jsonInput);
        
        // Create CSV schema (header will be automatically generated from JSON properties)
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
        
        // Write CSV file
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File(csvOutputPath), jsonTree);
    }

    public static void main(String[] args) {
        try {
            String jsonInput = "[{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}," +
                              "{\"name\":\"Jane\",\"age\":25,\"city\":\"Chicago\"}]";
            String csvOutputPath = "output.csv";
            
            convertJsonToCsv(jsonInput, csvOutputPath);
            System.out.println("CSV file created successfully at: " + csvOutputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JsonToCsvConverter {

    public static void convertJsonToCsv(String jsonString, String csvFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonString);

        // Determine if the root is an array or a single object
        if (rootNode.isArray()) {
            convertJsonArrayToCsv((ArrayNode) rootNode, csvFilePath);
        } else if (rootNode.isObject()) {
            // If it's a single object, wrap it in an array for consistent processing
            ArrayNode arrayNode = mapper.createArrayNode();
            arrayNode.add(rootNode);
            convertJsonArrayToCsv(arrayNode, csvFilePath);
        } else {
            throw new IllegalArgumentException("Unsupported JSON structure. Expected an array or object.");
        }
    }

    private static void convertJsonArrayToCsv(ArrayNode jsonArray, String csvFilePath) throws IOException {
        if (jsonArray.isEmpty()) {
            System.out.println("JSON array is empty. No CSV will be generated.");
            return;
        }

        Set<String> headers = new LinkedHashSet<>();
        List<List<String>> dataRows = new ArrayList<>();

        // 1. Collect all unique headers from all objects
        for (JsonNode node : jsonArray) {
            if (node.isObject()) {
                ObjectNode objNode = (ObjectNode) node;
                Iterator<String> fieldNames = objNode.fieldNames();
                while (fieldNames.hasNext()) {
                    headers.add(fieldNames.next());
                }
            }
        }

        // 2. Prepare data rows
        for (JsonNode node : jsonArray) {
            if (node.isObject()) {
                ObjectNode objNode = (ObjectNode) node;
                List<String> row = new ArrayList<>();
                for (String header : headers) {
                    JsonNode valueNode = objNode.get(header);
                    if (valueNode != null) {
                        // Handle potential nested JSON (e.g., objects or arrays)
                        // For simplicity, we'll convert nested structures to their string representation.
                        // You might need more sophisticated handling for complex nested data.
                        row.add(escapeCsvValue(valueNode.asText()));
                    } else {
                        row.add(""); // Empty string for missing values
                    }
                }
                dataRows.add(row);
            }
        }

        // 3. Write to CSV file
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            // Write headers
            writer.append(String.join(",", headers));
            writer.append("\n");

            // Write data rows
            for (List<String> row : dataRows) {
                writer.append(String.join(",", row));
                writer.append("\n");
            }
        }
    }

    private static String escapeCsvValue(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        // If the value contains a comma, double quote, or newline, enclose it in double quotes.
        // And escape existing double quotes by doubling them.
        if (value.contains(",") || value.contains("\"") || value.contains("\n") || value.contains("\r")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }

    public static void main(String[] args) {
        String json1 = "[{\"name\": \"Alice\", \"age\": 30, \"city\": \"New York\"}," +
                       "{\"name\": \"Bob\", \"age\": 24, \"city\": \"London\", \"occupation\": \"Engineer\"}]";

        String json2 = "{\"product\": \"Laptop\", \"price\": 1200, \"description\": \"Powerful machine.\"}";

        String json3 = "[{\"id\": 1, \"data\": {\"key1\": \"value1\", \"key2\": \"value2\"}}," +
                       "{\"id\": 2, \"data\": {\"key1\": \"valueA\", \"key3\": \"valueB\"}}]"; // Nested JSON example

        String json4 = "[]"; // Empty JSON array

        try {
            System.out.println("Converting json1.json to output1.csv...");
            convertJsonToCsv(json1, "output1.csv");
            System.out.println("output1.csv generated successfully.");

            System.out.println("\nConverting json2.json to output2.csv...");
            convertJsonToCsv(json2, "output2.csv");
            System.out.println("output2.csv generated successfully.");

            System.out.println("\nConverting json3.json (with nested data) to output3.csv...");
            convertJsonToCsv(json3, "output3.csv");
            System.out.println("output3.csv generated successfully.");

            System.out.println("\nConverting json4.json (empty) to output4.csv...");
            convertJsonToCsv(json4, "output4.csv");
            System.out.println("output4.csv generated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


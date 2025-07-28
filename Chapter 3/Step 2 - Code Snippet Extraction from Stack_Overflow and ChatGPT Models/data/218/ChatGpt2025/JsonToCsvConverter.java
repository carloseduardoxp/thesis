import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class JsonToCsvConverter {

    public static void main(String[] args) {
        String jsonStr = "[{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}," +
                "{\"name\":\"Anna\",\"age\":22,\"city\":\"London\"}," +
                "{\"name\":\"Mike\",\"age\":32,\"city\":\"Chicago\"}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonStr);

            // Collect CSV headers from all keys of JSON objects (use LinkedHashSet to preserve order)
            Set<String> headers = new LinkedHashSet<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                headers.addAll(obj.keySet());
            }

            // Write CSV
            FileWriter csvWriter = new FileWriter("output.csv");

            // Write header row
            csvWriter.append(String.join(",", headers));
            csvWriter.append("\n");

            // Write data rows
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                for (String header : headers) {
                    String value = obj.optString(header, "");
                    // Escape quotes if needed
                    value = value.replace("\"", "\"\"");
                    // Wrap value with quotes if contains comma or quote
                    if (value.contains(",") || value.contains("\"")) {
                        value = "\"" + value + "\"";
                    }
                    csvWriter.append(value);
                    csvWriter.append(",");
                }
                // Remove trailing comma and add newline
                csvWriter.flush();
                csvWriter.getChannel().truncate(csvWriter.getChannel().position() - 1);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

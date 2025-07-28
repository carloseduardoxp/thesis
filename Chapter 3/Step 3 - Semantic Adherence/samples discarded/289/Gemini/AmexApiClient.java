import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class AmexApiClient {

    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper(); // For JSON serialization/deserialization

    // Replace with your actual API base URL
    private static final String BASE_URL = "https://api.americanexpress.com/payments/v2"; 
    private static final String CLIENT_ID = "YOUR_CLIENT_ID";
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET"; // Or use HMAC key

    // This is a simplified example. For actual Amex APIs, use amex-api-java-client-core for auth.
    public String authorizePayment(Map<String, Object> paymentPayload) throws IOException {
        String jsonPayload = objectMapper.writeValueAsString(paymentPayload);

        RequestBody body = RequestBody.create(jsonPayload, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(BASE_URL + "/authorizations")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                // For actual Amex APIs, you'd use HMAC authentication headers here.
                // Example (pseudo-code - replace with actual HMAC implementation):
                // .addHeader("x-amex-api-key", CLIENT_ID)
                // .addHeader("Authorization", "HMAC-SHA256 Signature=...")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + " - " + response.body().string());
            }
            return response.body().string();
        }
    }

    public static void main(String[] args) {
        AmexApiClient client = new AmexApiClient();

        // Example payment payload (structure will vary based on actual API)
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", 100.00);
        payload.put("currency", "USD");
        // In a real scenario, this would be a token, not raw card data
        Map<String, String> card = new HashMap<>();
        card.put("number", "4XXX-XXXX-XXXX-XXXX"); // Use a tokenized card number here
        card.put("expiryMonth", "12");
        card.put("expiryYear", "2025");
        card.put("cvv", "123");
        payload.put("card", card);

        try {
            String response = client.authorizePayment(payload);
            System.out.println("Authorization Response: " + response);
        } catch (IOException e) {
            System.err.println("Error authorizing payment: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

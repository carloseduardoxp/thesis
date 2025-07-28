import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class PaymentGatewayClient {

    private static final String API_URL = "https://gateway.ghlconnect.com/txnprocessor/transaction";
    private static final String API_USERNAME = "your_api_username";
    private static final String API_PASSWORD = "your_api_password";

    public void processPayment() throws IOException {
        // Create an HttpClient object
        HttpClient httpClient = HttpClients.createDefault();

        // Create a payment request
        String paymentRequest = "{\n" +
                "  \"Transaction\": {\n" +
                "    \"TransactionDetails\": {\n" +
                "      \"TransactionType\": \"SALE\",\n" +
                "      \"MerchantTransactionID\": \"1234567890\",\n" +
                "      \"TransactionAmount\": \"100.00\",\n" +
                "      \"CurrencyCode\": \"USD\",\n" +
                "      \"TransactionDateTime\": \"2022-04-04T12:00:00Z\"\n" +
                "    },\n" +
                "    \"PaymentMethod\": {\n" +
                "      \"Card\": {\n" +
                "        \"CardNumber\": \"378282246310005\",\n" +
                "        \"ExpiryDate\": \"1224\",\n" +
                "        \"CVV\": \"123\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Create a HttpPost object with the payment request
        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, getBasicAuthHeader(API_USERNAME, API_PASSWORD));
        httpPost.setEntity(new StringEntity(paymentRequest));

        // Send the request and get the response
        HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();
        String responseString = responseEntity != null ? EntityUtils.toString(responseEntity) : null;

        // Handle the response
        System.out.println(responseString);
    }

    private String getBasicAuthHeader(String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
        return "Basic " + new String(encodedAuth);
    }

}

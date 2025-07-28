import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/api");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Método GET, POST, etc.
        con.setRequestMethod("GET");

        // Definindo o header
        con.setRequestProperty("Authorization", "Bearer seu_token_aqui");
        con.setRequestProperty("Content-Type", "application/json");

        // Envie a requisição e leia a resposta, etc...
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}

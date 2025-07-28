import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = findViewById(R.id.my_webview);

        // Enable JavaScript (important for many websites)
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to handle page navigation within the WebView itself
        // Without this, links might open in the device's default browser
        myWebView.setWebViewClient(new WebViewClient());

        // Load a URL
        myWebView.loadUrl("https://www.example.com");
    }

    // Handle back button presses within the WebView
    @Override
    public void onBackPressed() {
        WebView myWebView = findViewById(R.id.my_webview);
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

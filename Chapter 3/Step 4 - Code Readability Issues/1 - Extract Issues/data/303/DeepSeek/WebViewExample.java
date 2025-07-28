import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create the WebView
        WebView webView = new WebView();
        
        // Load a website
        webView.getEngine().load("https://www.example.com");
        
        // Create the scene and show the stage
        Scene scene = new Scene(webView, 800, 600);
        primaryStage.setTitle("JavaFX WebView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

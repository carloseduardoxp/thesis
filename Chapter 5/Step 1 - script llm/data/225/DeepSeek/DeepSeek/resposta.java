import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadExample {
    public static void main(String[] args) {
        // Set the download directory path
        String downloadPath = "C:\\Downloads\\Selenium";
        
        // Create ChromeOptions to set preferences
        ChromeOptions options = new ChromeOptions();
        
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        
        options.setExperimentalOption("prefs", prefs);
        
        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        
        try {
            // Navigate to the page with download link
            driver.get("https://example.com/download-page");
            
        } finally {
            driver.quit();
        }
    }
}

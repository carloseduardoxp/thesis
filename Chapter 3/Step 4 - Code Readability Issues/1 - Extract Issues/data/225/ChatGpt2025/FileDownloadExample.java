import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadExample {
    public static void main(String[] args) {
        // Define the download directory path
        String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads";

        // Create download folder if it doesn't exist
        new File(downloadFilepath).mkdirs();

        // Set Chrome options
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath); // Set download folder
        prefs.put("download.prompt_for_download", false);          // Disable download prompt
        prefs.put("plugins.always_open_pdf_externally", true);     // For PDFs - disable preview

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://example.com/download-link"); // Replace with your URL

            // Click the download link/button
            driver.findElement(By.id("downloadButton")).click(); // Replace with correct locator

            // Wait or check if the file is downloaded (use Thread.sleep or a proper wait mechanism)
            Thread.sleep(5000); // Just for demonstration - use WebDriverWait or file-checking loop in practice

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

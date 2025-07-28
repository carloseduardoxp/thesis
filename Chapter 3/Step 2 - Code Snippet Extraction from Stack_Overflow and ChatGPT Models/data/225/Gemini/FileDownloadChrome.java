import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadChrome {

    public static void main(String[] args) throws InterruptedException {

        // 1. Define the download directory
        String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads";
        File downloadDir = new File(downloadFilepath);
        if (!downloadDir.exists()) {
            downloadDir.mkdirs(); // Create the directory if it doesn't exist
        }

        // 2. Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        // Set the default download directory
        prefs.put("download.default_directory", downloadFilepath);
        // Disable download prompt (automatically save to default directory)
        prefs.put("download.prompt_for_download", false);
        // For PDF files, ensure they are downloaded rather than opened in the browser
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("profile.default_content_settings.popups", 0); // Disable pop-ups

        options.setExperimentalOption("prefs", prefs);

        // 3. Initialize ChromeDriver with the configured options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // 4. Navigate to a page with a downloadable file
            driver.get("https://freetestdata.com/document-files/pdf/"); // Example URL for a PDF download

            // Find and click the download link (adjust locator as needed)
            WebElement downloadLink = driver.findElement(By.xpath("//a[contains(@href,'.pdf')]")); // Example: finds a link with .pdf in its href
            downloadLink.click();

            // 5. Wait for the download to complete
            // This is a simple wait. In a real scenario, consider more robust waits.
            // For example, checking if the file appears in the directory.
            Thread.sleep(5000); // Wait for 5 seconds for the download to finish

            // 6. Verify the file download
            String fileName = "Free_Test_Data_100KB_PDF.pdf"; // Adjust to the actual file name
            File downloadedFile = new File(downloadFilepath + File.separator + fileName);

            if (downloadedFile.exists()) {
                System.out.println("File is downloaded successfully: " + downloadedFile.getAbsolutePath());
                // You can add further assertions here, like checking file size or content
            } else {
                System.out.println("File was NOT downloaded.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Quit the WebDriver
            driver.quit();
        }
    }
}

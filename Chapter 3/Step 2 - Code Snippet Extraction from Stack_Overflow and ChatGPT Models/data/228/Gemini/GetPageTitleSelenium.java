import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; // Or FirefoxDriver, EdgeDriver, etc.

public class GetPageTitleSelenium {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable (e.g., chromedriver.exe)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.example.com"); // Navigate to the URL
            String pageTitle = driver.getTitle(); // Get the page title
            System.out.println("Page Title: " + pageTitle);
        } finally {
            driver.quit(); // Close the browser
        }
    }
}

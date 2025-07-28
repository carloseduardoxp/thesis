import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementTitle {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to the webpage
            driver.get("https://example.com");
            
            // Find the element (using any locator strategy)
            WebElement element = driver.findElement(By.id("someId")); // or By.cssSelector, By.xpath, etc.
            
            // Get the title attribute
            String title = element.getAttribute("title");
            
            System.out.println("Element title: " + title);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

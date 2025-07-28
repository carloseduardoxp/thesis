import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleExample {
    public static void main(String[] args) {
        // Set path to chromedriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Locate element
        WebElement element = driver.findElement(By.id("myElement"));

        // Get the title attribute
        String title = element.getAttribute("title");
        System.out.println("Title: " + title);

        driver.quit();
    }
}

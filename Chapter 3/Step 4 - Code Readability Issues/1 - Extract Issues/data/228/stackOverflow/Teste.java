public class Teste {

    public static void main(String[] args) {        
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Some name']/.."));
        // or By.xpath("//*[text() = 'Some name']/parent::tr");
        String val = element.getAttribute("data-key");
        System.out.print(val);
    }
}
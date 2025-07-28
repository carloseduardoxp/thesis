public class Teste {

    public static void main(String[] args) {        
        WebElement element = driver.findElement(By.xpath("//*[text() = 'Some name']/.."));
        String val = element.getAttribute("data-key");
        System.out.print(val);
    }
}
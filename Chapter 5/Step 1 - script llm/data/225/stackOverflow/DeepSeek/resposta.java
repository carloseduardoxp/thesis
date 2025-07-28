public class Teste {

    public static void main(String[] args) {        
        FirefoxProfile prof = new FirefoxProfile();

        prof.setPreference("browser.download.dir","D:\\selenium\\");
        prof.setPreference("browser.download.folderList", 2);
        prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

        WebDriver driver = new FirefoxDriver(prof);
        driver.get("http://docs.seleniumhq.org/download/");
        driver.findElement(By.xpath("//tr[1]/td[4]/a[text()='Download']")).click();
    }
}

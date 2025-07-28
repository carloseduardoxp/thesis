public class Teste {

    public static void main(String[] args) {        
        //common to all the cases
        FirefoxProfile prof = new FirefoxProfile();

        //Case:3 - Download to custom folder path. Replace d:\\selenium with your Download Location 
        prof.setPreference("browser.download.dir","D:\\selenium\\");
        prof.setPreference("browser.download.folderList", 2);
        prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

        //This will work for all cases mentioned above
        WebDriver driver = new FirefoxDriver(prof);
        driver.get("http://docs.seleniumhq.org/download/");
        driver.findElement(By.xpath("//tr[1]/td[4]/a[text()='Download']")).click();
    }
}

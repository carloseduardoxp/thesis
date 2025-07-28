public class Teste {
  public static void main(String[] args) {
        // Assuming you've already created a WebDriver instance
    // and navigated to the page with the download link/button

    // Find the download element
    WebElement downloadLink = driver.findElement(By.xpath("//a[contains(text(),'Download')]"));

    // Click on the download element
    downloadLink.click();

    // Wait for the file to download
    File file = new File("/path/to/downloaded/file");
    while (!file.exists()) {
        Thread.sleep(1000); // Wait for 1 second
    }

    // Once the file is downloaded, perform any necessary actions on it
    // For example, you could read the contents of the file
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    reader.close();

  }
}

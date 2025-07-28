import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Example {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new sheet
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create some rows and cells
        Row row1 = sheet.createRow(0);
        Cell cellA1 = row1.createCell(0);
        cellA1.setCellValue("Hello");
        Cell cellB1 = row1.createCell(1);
        cellB1.setCellValue("world!");

        Row row2 = sheet.createRow(1);
        Cell cellA2 = row2.createCell(0);
        cellA2.setCellValue(123);
        Cell cellB2 = row2.createCell(1);
        cellB2.setCellValue(456);

        // Save the workbook
        try (FileOutputStream outputStream = new FileOutputStream("example.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

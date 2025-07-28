import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColumnsExample {
   public static void main(String[] args) {
      try (Workbook workbook = new XSSFWorkbook()) {
         Sheet sheet = workbook.createSheet("Sheet1");

         // Create the header row
         Row headerRow = sheet.createRow(0);
         headerRow.createCell(0).setCellValue("Name");
         headerRow.createCell(1).setCellValue("Age");
         headerRow.createCell(2).setCellValue("City");

         // Set the column widths
         sheet.setColumnWidth(0, 5000);
         sheet.setColumnWidth(1, 3000);
         sheet.setColumnWidth(2, 7000);

         // Create some data rows
         Row dataRow1 = sheet.createRow(1);
         dataRow1.createCell(0).setCellValue("John");
         dataRow1.createCell(1).setCellValue(30);
         dataRow1.createCell(2).setCellValue("New York");

         Row dataRow2 = sheet.createRow(2);
         dataRow2.createCell(0).setCellValue("Jane");
         dataRow2.createCell(1).setCellValue(25);
         dataRow2.createCell(2).setCellValue("San Francisco");

         // Save the workbook to a file
         try (FileOutputStream outputStream = new FileOutputStream("example.xlsx")) {
            workbook.write(outputStream);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DeepSeek {

    public static void main(String[] args) {
        
    
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet
        Sheet sheet = workbook.createSheet("Employee Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Salary");

        // Add data rows
        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue(1);
        dataRow1.createCell(1).setCellValue("John Doe");
        dataRow1.createCell(2).setCellValue(50000);

        // Write to file
        try (FileOutputStream outputStream = new FileOutputStream("employees.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        }
    }
}


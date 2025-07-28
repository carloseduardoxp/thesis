import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelColumnsExample {
    public static void main(String[] args) {
        // Create a workbook (XSSFWorkbook for .xlsx files)
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet in the workbook
        Sheet sheet = workbook.createSheet("MySheet");

        // Create a row at index 0
        Row row = sheet.createRow(0);

        // Create cells (columns) in the row
        Cell cell0 = row.createCell(0); // column A
        cell0.setCellValue("Name");

        Cell cell1 = row.createCell(1); // column B
        cell1.setCellValue("Age");

        Cell cell2 = row.createCell(2); // column C
        cell2.setCellValue("Country");

        // Create another row (row 1) and fill data in columns
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Alice");
        row1.createCell(1).setCellValue(30);
        row1.createCell(2).setCellValue("USA");

        // Adjust column widths to fit content
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("example.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; // For .xls files

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelColumnsExample {

    public static void main(String[] args) {
        // Choose between HSSFWorkbook (for .xls) or XSSFWorkbook (for .xlsx)
        // Workbook workbook = new HSSFWorkbook();
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Column Data");

        // ... (add your column operations here)

        try (FileOutputStream outputStream = new FileOutputStream("ColumnsExample.xlsx")) {
            workbook.write(outputStream);
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

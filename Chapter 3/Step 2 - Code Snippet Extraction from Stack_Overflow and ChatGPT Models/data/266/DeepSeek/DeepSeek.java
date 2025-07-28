
import org.apache.poi.ss.usermodel.*;

public class DeepSeek {

    public static void main(String[] args) {

// Create or get a sheet
        Sheet sheet = workbook.createSheet("Sheet1");

// Set width for column A (index 0)
        sheet.setColumnWidth(0, 20 * 256); // Width in 1/256th of a character width

// Auto-size column B (index 1)
        sheet.autoSizeColumn(1);

    }

}

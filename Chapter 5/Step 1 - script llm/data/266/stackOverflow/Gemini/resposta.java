import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Teste {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\workspace\\Writesheet.xlsx");
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet spreadsheet = workbook.getSheetAt(0);

            // getLastCellNum() returns the last cell number + 1, which is the total number of cells.
            // The loop should iterate from 0 to lastcell - 1.
            int lastcell = spreadsheet.getRow(0).getLastCellNum();

            for (int i = 0; i < lastcell; i++) {
                System.out.println(CellReference.convertNumToColString(i));
            }
        }
    }
}

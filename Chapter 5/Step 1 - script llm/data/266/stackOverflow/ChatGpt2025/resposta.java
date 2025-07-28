import java.io.FileInputStream;
import java.io.File;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Teste {

    public static void main(String[] args) throws Exception {        
        FileInputStream fis = new FileInputStream(
            new File("D:\\workspace\\Writesheet.xlsx"));
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        int lastcell = spreadsheet.getRow(0).getLastCellNum();
        // Non empty Last cell Number or index return

        for (int i = 0; i <= lastcell; i++) {
            System.out.println(CellReference.convertNumToColString(i));
        }
        fis.close();
    }
}

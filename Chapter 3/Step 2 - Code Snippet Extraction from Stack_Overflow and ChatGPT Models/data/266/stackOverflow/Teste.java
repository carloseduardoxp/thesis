
import java.io.FileInputStream;

public class Teste {

    public static void main(String[] args) {        
        FileInputStream fis = new FileInputStream(
            new File("D:\\workspace\\Writesheet.xlsx"));
            @SuppressWarnings("resource")
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
      
            int lastcell=spreadsheet.getRow(0).getLastCellNum();
            //Non empty Last cell Number or index return
      
            for(int i=0;i<=lastcell;i++)
            {
                try
                {
                    System.out.println(CellReference.convertNumToColString(i));
                }catch(Exception e)
                {}
            }
            fis.close();
    }
}
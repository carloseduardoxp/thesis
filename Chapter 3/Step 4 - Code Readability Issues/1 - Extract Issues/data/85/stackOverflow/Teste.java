
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

    public static String readExcel(String filePath, String fileName, String sheetName, int RowNumber, int ColNumber) throws Exception {

        Object result = null;
        try {

            sheet = getSheet(filePath, fileName, sheetName);
            row = sheet.getRow(RowNumber);

            if (row != null) {
                //System.out.println("Row is not empty");
                cell = row.getCell(ColNumber);

                if (cell != null) {
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:// numeric value in excel
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date myDate = cell.getDateCellValue();
                                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                String result = formatter.format(myDate);
                                System.out.println("Today : " + result);
                            } else {
                                result = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                            }
                            break;

                        case Cell.CELL_TYPE_STRING: // string value in excel
                            result = cell.getStringCellValue();
                            break;

                        case Cell.CELL_TYPE_BOOLEAN: // boolean value in excel
                            result = cell.getBooleanCellValue();
                            break;

                        case Cell.CELL_TYPE_BLANK: // blank value in excel
                            result = cell.getStringCellValue();
                            break;

                        case Cell.CELL_TYPE_ERROR: // Error value in excel
                            result = cell.getErrorCellValue() + "";
                            break;

                    }
                } else {
                    return null;
                }
            } else {
                //System.out.println("Row is empty");
                return null;
            }

            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result.toString();

    }

}

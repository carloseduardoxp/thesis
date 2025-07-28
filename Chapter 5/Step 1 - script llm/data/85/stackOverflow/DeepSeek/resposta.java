import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

    public static String readExcel(String filePath, String fileName, String sheetName, int rowNumber, int colNumber) throws Exception {

        Object result = null;
        try {

            sheet = getSheet(filePath, fileName, sheetName);
            row = sheet.getRow(rowNumber);

            if (row != null) {
                cell = row.getCell(colNumber);

                if (cell != null) {
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date myDate = cell.getDateCellValue();
                                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                String result = formatter.format(myDate);
                                System.out.println("Today : " + result);
                            } else {
                                result = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                            }
                            break;

                        case Cell.CELL_TYPE_STRING:
                            result = cell.getStringCellValue();
                            break;

                        case Cell.CELL_TYPE_BOOLEAN:
                            result = cell.getBooleanCellValue();
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            result = cell.getStringCellValue();
                            break;

                        case Cell.CELL_TYPE_ERROR:
                            result = cell.getErrorCellValue() + "";
                            break;

                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }

            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result.toString();
    }
}

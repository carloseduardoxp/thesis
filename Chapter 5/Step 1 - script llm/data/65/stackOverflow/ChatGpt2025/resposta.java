import java.util.Iterator;

public class Teste {

    public static void main(String[] args) {
        Iterator<Sheet> sheetIterator = workbook.iterator();
        while (sheetIterator.hasNext()) {
            sheetIterator.next();
        }

        sheetIterator.next();
    }
    
}
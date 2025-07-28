
import java.io.File;
import java.io.FileReader;
import java.util.List;


public class CSVParser {

    public static void main(String[] args) {

        CsvParserSettings settings = new CsvParserSettings(); //lots of options here, check the documentation

        CsvParser parser = new CsvParser(settings);

        List<String[]> allRows = parser.parseAll(new FileReader(new File("path/to/input.csv")));

    }

}

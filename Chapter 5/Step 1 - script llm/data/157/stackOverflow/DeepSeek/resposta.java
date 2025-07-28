import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CSVParser {

    public static void main(String[] args) {
        CsvParserSettings settings = new CsvParserSettings();
        CsvParser parser = new CsvParser(settings);
        parser.parseAll(new FileReader(new File("path/to/input.csv")));
    }

}


import java.io.File;
import java.io.FilenameFilter;

public class Teste {

    public static void main(String[] args) {
        File dir = new File("/path/to/pdfs");
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches("Comp_20120619_[^_]*_2_632128_FC_A_8_23903.pdf");
            }
        });
    }

}

import java.io.File;

public class Teste {

    public static void main(String[] args) {
        new File("/path/to/pdfs").listFiles(
            (dir, name) -> name.matches("Comp_20120619_[^_]*_2_632128_FC_A_8_23903.pdf")
        );
    }

}
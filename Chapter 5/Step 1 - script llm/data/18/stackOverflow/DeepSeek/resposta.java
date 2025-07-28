import java.io.File;

public class Teste {

    public static void main(String[] args) {
        File f = new File("fileToDelete");
        f.delete();
    }

}

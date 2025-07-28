import java.io.File;

public class Teste {

    public static void main(String[] args) {

//delete file
        File f = new File("fileToDelete");
        f.delete();
    }

}
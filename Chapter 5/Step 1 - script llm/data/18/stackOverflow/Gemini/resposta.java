import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

    private static final Logger LOGGER = Logger.getLogger(Teste.class.getName());

    public static void main(String[] args) {

        // delete file
        File f = new File("fileToDelete");
        if (!f.delete()) {
            LOGGER.log(Level.WARNING, "Failed to delete the file.");
        }
    }

}

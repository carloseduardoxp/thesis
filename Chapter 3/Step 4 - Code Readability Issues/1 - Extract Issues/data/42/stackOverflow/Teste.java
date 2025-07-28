import java.io.File;

public class Teste {

    
    public void delete(File path){
        File[] l = path.listFiles();
        for (File f : l){
            if (f.isDirectory())
                delete(f);
            else
                f.delete();
        }
        path.delete(); 
    }
    
}
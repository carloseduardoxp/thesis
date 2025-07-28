
import java.io.File;

public class Teste {

    public static void main(String[] args) {

        recursiveList("D:");

    }

    public static void recursiveList(String path) {

        File f = new File(path);
        File[] fl = f.listFiles();
        for (int i = 0; i < fl.length; i++) {
            if (fl[i].isDirectory() && !fl[i].isHidden()) {
                System.out.println(fl[i].getAbsolutePath());
                recursiveList(fl[i].getAbsolutePath());
            } else {
                System.out.println(fl[i].getName());
            }
        }
    }

}
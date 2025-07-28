import java.io.File;

public class MainEntry {

    public static void main(String[] args) {
        walkin(new File("/home/user")); //Replace this with a suitable directory
    }

    /**
     * Recursive function to descend into the directory tree and find all the
     * files
     *
     * @param dir A file object defining the top directory
     *
     */
    public static void walkin(File dir) {

        File[] listFile = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    System.out.println("|\t\t");
                    walkin(listFile[i]);
                } else {

                    System.out.println("+---" + listFile[i].getName());

                }
            }
        }
    }
}
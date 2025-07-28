import java.io.File;

public class FileRenameExample {
    public static void main(String[] args) {
        File folder = new File("path/to/folder");

        File[] files = folder.listFiles();

        for (File file : files) {
            String oldName = file.getName();
            String newName = "new_" + oldName;
            File newFile = new File(folder.getPath() + "\\" + newName);
            file.renameTo(newFile);
        }
    }
}

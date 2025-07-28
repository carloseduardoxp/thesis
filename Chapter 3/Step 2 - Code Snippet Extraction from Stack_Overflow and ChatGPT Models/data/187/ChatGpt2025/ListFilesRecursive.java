import java.io.File;

public class ListFilesRecursive {

    public static void listFiles(File folder) {
        if (folder == null || !folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }
        if (!folder.isDirectory()) {
            System.out.println(folder.getAbsolutePath() + " is not a directory.");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("Could not list files in " + folder.getAbsolutePath());
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively list files in subdirectory
                listFiles(file);
            } else {
                // It's a file, print it
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File folder = new File("path/to/your/folder");
        listFiles(folder);
    }
}

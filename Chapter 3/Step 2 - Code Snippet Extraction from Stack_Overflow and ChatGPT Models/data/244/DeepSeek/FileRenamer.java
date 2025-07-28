import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        File folder = new File("path/to/your/folder");
        
        // List all files in the folder
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // Create new file name (modify this logic as needed)
                    String newName = "prefix_" + file.getName();
                    File newFile = new File(folder.getPath() + File.separator + newName);
                    
                    // Rename the file
                    boolean success = file.renameTo(newFile);
                    
                    if (success) {
                        System.out.println("Renamed: " + file.getName() + " to " + newName);
                    } else {
                        System.out.println("Failed to rename: " + file.getName());
                    }
                }
            }
        }
    }
}

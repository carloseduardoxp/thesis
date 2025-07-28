import java.io.*;

public class Teste {

    public static void main(String[] args) {        
        File dir = new File("D:/xyz");

        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles()) {
                try {
                    File newfile =new File("newfile.txt");
        
                    if(f.renameTo(newfile)){
                        System.out.println("Rename succesful");
                    }else{
                        System.out.println("Rename failed");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
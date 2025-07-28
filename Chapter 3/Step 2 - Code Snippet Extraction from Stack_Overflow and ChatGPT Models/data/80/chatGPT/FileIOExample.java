import java.io.*;

public class FileIOExample {
    public static void main(String[] args) {
        try {
            // Create a FileReader object to read the input file
            FileReader fileReader = new FileReader("input.txt");
            
            // Create a BufferedReader object to read the file in chunks
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // Create a FileWriter object to write the output file
            FileWriter fileWriter = new FileWriter("output.txt");
            
            // Read each line of the input file and write it to the output file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            
            // Close the input and output streams
            bufferedReader.close();
            fileWriter.close();
            
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

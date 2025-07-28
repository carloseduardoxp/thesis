import java.io.RandomAccessFile;

public class EOFExample {
    public static void main(String[] args) throws Exception {
        String fileName = "example.txt";
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            long position = file.length();
            file.setLength(position + 1);
            file.seek(position);
            file.writeByte(0); // writes the EOF character
        }
    }
}

import java.io.*;
import java.nio.channels.*;

public class TransferFromExample {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destFile = new File("dest.txt");

        try (
            FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
            FileChannel destChannel = new FileOutputStream(destFile).getChannel()
        ) {
            long size = sourceChannel.size();
            long position = 0;
            long transferred;

            // Loop para garantir que todos os dados sejam transferidos
            while (position < size) {
                transferred = destChannel.transferFrom(sourceChannel, position, size - position);
                if (transferred == 0) break; // Evita loop infinito se não conseguir transferir
                position += transferred;
            }

            System.out.println("Transferência completa.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

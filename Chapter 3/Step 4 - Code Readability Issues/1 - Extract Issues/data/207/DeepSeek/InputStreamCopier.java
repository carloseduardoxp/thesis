import java.io.*;

public class InputStreamCopier {
    public static Pair<InputStream, InputStream> copy(InputStream input) throws IOException {
        byte[] bytes = input.readAllBytes();
        return new Pair<>(
            new ByteArrayInputStream(bytes),
            new ByteArrayInputStream(bytes)
        );
    }
    
    // Simple pair class
    public static class Pair<A, B> {
        public final A first;
        public final B second;
        
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}

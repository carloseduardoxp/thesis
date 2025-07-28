import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalInput = "Texto para converter em Base64";
        
        // Converter string para bytes
        byte[] bytes = originalInput.getBytes();
        
        // Codificar em Base64
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        
        System.out.println("Original: " + originalInput);
        System.out.println("Base64: " + encodedString);
    }
}

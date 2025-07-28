import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Teste {

    public static void main(String[] args) {
        // Encoding Bytes
        byte[] base64Encoded = Base64.getEncoder().encode("Hello World".getBytes(StandardCharsets.UTF_8));
        String encodedHexString = getHexString(base64Encoded, base64Encoded.length);
        T1.setText(encodedHexString);  //-- for output

        // Decoding Bytes
        byte[] decodedHexArray = hexStringToByteArray(encodedHexString);
        byte[] base64Decoded = Base64.getDecoder().decode(decodedHexArray);

        // Displaying Decoded Byte Array by Converting it To String
        String resultDecoded = new String(base64Decoded, StandardCharsets.UTF_8);
        T2.setText(resultDecoded);   //This Displays Hello World :)
    }

    // Following are the functions that I used above !
    public static String getHexString(byte[] bytes, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public static String bytesToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            buf.append(byteToHex(data[i]));
            buf.append(" ");
        }
        return buf.toString();
    }

    public static String byteToHex(byte data) {
        StringBuilder buf = new StringBuilder();
        buf.append(toHexChar((data >>> 4) & 0x0F));
        buf.append(toHexChar(data & 0x0F));
        return buf.toString();
    }

    public static char toHexChar(int i) {
        if ((0 <= i) && (i <= 9)) {
            return (char) ('0' + i);
        } else {
            return (char) ('a' + (i - 10));
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

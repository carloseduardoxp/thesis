import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Teste {

    public static void main(String[] args) {        
        // Encoding Bytes
        byte[] b64Enc = Base64.encode("Hello World".getBytes(StandardCharsets.UTF_8));
        String encStr = getHexString(b64Enc, b64Enc.length);
        T1.setText(encStr);  //-- for output
        
        // Decoding Bytes
        byte[] decBarray = hexStringToByteArray(encStr);
        byte[] b64Dec = Base64.decode(decBarray);
        
        // Displaying Decoded Byte Array by Converting it To String
        try {
            String resDec = new String(b64Dec, StandardCharsets.UTF_8);
            T2.setText(resDec);   //This Displays Hello World :)
        
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getHexString(byte[] b, int length) {
        String result = "";

        for (int i = 0; i < length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    public static String bytesToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            buf.append(byteToHex(data[i]));
            buf.append(" ");
        }
        return (buf.toString());
    }

    public static String byteToHex(byte data) {
        StringBuffer buf = new StringBuffer();
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

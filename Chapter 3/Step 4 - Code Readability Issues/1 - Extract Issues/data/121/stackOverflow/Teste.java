import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Teste {

    public static void main(String[] args) {        
        // Encoding Bytes
        byte[] b64ENC = Base64.encode("Hello World".getBytes("UTF-8"));
        String ENCStr = getHexString(b64ENC,b64ENC.length);
        T1.setText(ENCStr);  //-- for output
        
        // Decoding Bytes
        byte[] DECBarray = hexStringToByteArray(ENCStr);
        byte[] b64DEC = Base64.decode(DECBarray);
        
        // Displaying Decoded Byte Array by Converting it To String
        try {
            String ResDec = new String(b64DEC,"UTF-8");
            T2.setText(ResDec);   //This Displays Hello World :)
        
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Following are the functions that I used above !
    public String getHexString(byte[] b, int length) {
        // TODO Auto-generated method stub
        String result = "";

        for (int i = 0; i < length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring(1);
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
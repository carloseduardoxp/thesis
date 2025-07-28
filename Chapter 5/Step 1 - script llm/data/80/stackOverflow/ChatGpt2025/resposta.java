import java.io.DataInputStream;
import java.io.InputStream;

public class Teste {

    public static void main(String[] args) {
        FileConnection fileConn = (FileConnection) Connector.open(path + fName, Connector.READ);
        InputStream is = fileConn.openInputStream();
        DataInputStream dis = new DataInputStream(is);
        int ch;
        String str = "";
        while ((ch = dis.read()) != -1) {
            str += ((char) ch);
        }
        dis.close();
        is.close();

        // Assuming `str` contains the data read from file
        String header = str.substring(0, 64);
        String theRestOfFile = str.substring(64);

        FileConnection fileConnRW = (FileConnection) Connector.open(path + fName, Connector.READ_WRITE);
        if (!fileConnRW.exists()) {
            items.alert = new Alert(" ", "Select The Directory", null, AlertType.INFO);
            switchDisplayable(items.alert, items.getList());
            fileConnRW.create();
        }
        os = fileConnRW.openDataOutputStream();
        fileConnRW.truncate(0);
        // Change `theRestOfFile` somehow
        // ...
        os.write(header.getBytes());
        os.write(theRestOfFile.getBytes());

        os.close();
        fileConnRW.close();

    }

}
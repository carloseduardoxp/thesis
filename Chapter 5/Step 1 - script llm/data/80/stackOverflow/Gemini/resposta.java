import java.io.DataInputStream;
import java.io.InputStream;

public class Teste {

    public static void main(String[] args) {
        FileConnection fconn = (FileConnection) Connector.open(path + fName, Connector.READ);
        InputStream is = fconn.openInputStream();
        DataInputStream dis = new DataInputStream(is);
        int ch;
        StringBuilder strBuilder = new StringBuilder();
        while ((ch = dis.read()) != -1) {
            strBuilder.append((char) ch);
        }
        dis.close();
        is.close();
        fconn.close();

        String str = strBuilder.toString();
        // Assuming `str` contains the data read from file
        String header = str.substring(0, 64);
        String theRestOfFile = str.substring(64);

        fconn = (FileConnection) Connector.open(path + fName, Connector.READ_WRITE);
        if (!fconn.exists()) {
            items.alert = new Alert(" ", "Select The Directory", null, AlertType.INFO);
            switchDisplayable(items.alert, items.getList());
            fconn.create();
        }
        os = fconn.openDataOutputStream();
        fconn.truncate(0);
        // Change `theRestOfFile` somehow
        // ...
        os.write(header.getBytes());
        os.write(theRestOfFile.getBytes());

        os.close();
        fconn.close();

    }

}

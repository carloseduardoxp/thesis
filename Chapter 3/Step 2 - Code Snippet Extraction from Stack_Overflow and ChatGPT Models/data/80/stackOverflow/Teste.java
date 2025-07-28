
import java.io.DataInputStream;
import java.io.InputStream;

public class Teste {

    public static void main(String[] args) {
        FileConnection fconn = (FileConnection) Connector.open(path + fName, Connector.READ);
        InputStream is = fconn.openInputStream();
        DataInputStream dis = new DataInputStream(is);
        int ch;
        String str = new String();
        while ((ch = dis.read()) != -1) {
            str += ((char) ch);
        }
        dis.close();
        is.close();

        // Assuming `str` contains the data read from file
        String header = str.substring(0, 64);
        String the_rest_of_file = str.substring(64);

        FileConnection fconn = (FileConnection) Connector.open(path + fName, Connector.READ_WRITE);
        if (!fconn.exists()) {
            items.alert = new Alert(" ", "Select The Directory", null, AlertType.INFO);
            switchDisplayable(items.alert, items.getList());
            fconn.create();
        }
        os = fconn.openDataOutputStream();
        fconn.truncate(0);
        // Change `the_rest_of_file` somehow
        // ...
        os.write(header.getBytes());
        os.write(the_rest_of_file.getBytes());

        os.close();
        fconn.close();

    }

}

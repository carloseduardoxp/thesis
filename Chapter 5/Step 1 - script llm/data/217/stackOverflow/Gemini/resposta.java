import javax.comm.CommPort;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

public class Main implements SerialPortEventListener {

    public static void main(String[] args) {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/tty1");
        CommPort commPort = portIdentifier.open("owner-name", 2000);
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        // Method implementation is required by the SerialPortEventListener interface.
    }
}

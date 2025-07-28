import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

public class Main implements SerialPortEventListener {

    public static void main(String[] args) {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/tty1");
        CommPort commPort = portIdentifier.open("owner-name", 2000);
        if (commPort instanceof SerialPort) {
            SerialPort serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(rate, databits, stopbits, parity);
            serialPort.getInputStream();
            serialPort.getOutputStream();
        }
    }
}

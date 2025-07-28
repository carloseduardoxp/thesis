import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;

public class SerialReadExample {
    public static void main(String[] args) {
        // List all available ports
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Available Ports:");
        for (SerialPort port : ports) {
            System.out.println(port.getSystemPortName());
        }

        // Open a port (change "COM3" or "/dev/ttyUSB0" as per your system)
        SerialPort serialPort = SerialPort.getCommPort("COM3");
        serialPort.setBaudRate(9600);

        if (serialPort.openPort()) {
            System.out.println("Port opened successfully.");

            InputStream in = serialPort.getInputStream();
            try {
                byte[] buffer = new byte[1024];
                int len = -1;

                while ((len = in.read(buffer)) > -1) {
                    String received = new String(buffer, 0, len);
                    System.out.print(received);  // or process the data
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                serialPort.closePort();
                System.out.println("Port closed.");
            }

        } else {
            System.out.println("Failed to open the port.");
        }
    }
}

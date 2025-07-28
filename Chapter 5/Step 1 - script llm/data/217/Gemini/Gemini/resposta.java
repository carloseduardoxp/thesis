import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.IOException;

public class SerialPortReader {

    public static void main(String[] args) {
        // 1. List available serial ports
        SerialPort[] comPorts = SerialPort.getCommPorts();

        if (comPorts.length == 0) {
            System.out.println("No serial ports found.");
            return;
        }

        System.out.println("Available Serial Ports:");
        for (int i = 0; i < comPorts.length; i++) {
            System.out.println(i + ": " + comPorts[i].getSystemPortName() + " (" + comPorts[i].getDescriptivePortName() + ")");
        }

        // 2. Select a port (for demonstration, let's pick the first one)
        SerialPort chosenPort = null;
        if (comPorts.length > 0) {
            chosenPort = comPorts[0];
        }

        if (chosenPort == null) {
            System.out.println("No port selected or invalid selection.");
            return;
        }

        System.out.println("\nAttempting to open port: " + chosenPort.getSystemPortName());

        // 3. Open the port
        if (chosenPort.openPort()) {
            System.out.println("Port " + chosenPort.getSystemPortName() + " opened successfully.");

            // 4. Configure port parameters (adjust as needed for your device)
            chosenPort.setBaudRate(9600);           // Common baud rates: 9600, 19200, 38400, 115200
            chosenPort.setNumDataBits(8);           // 7 or 8
            chosenPort.setNumStopBits(SerialPort.ONE_STOP_BIT); // ONE_STOP_BIT, ONE_POINT_FIVE_STOP_BITS, TWO_STOP_BITS
            chosenPort.setParity(SerialPort.NO_PARITY); // NO_PARITY, EVEN_PARITY, ODD_PARITY, MARK_PARITY, SPACE_PARITY
            chosenPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED); // FLOW_CONTROL_DISABLED, FLOW_CONTROL_RTS_ENABLED, etc.

            // Optional: Set timeouts for read operations
            chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

            // 5. Read data using an event listener
            System.out.println("\n--- Event-Driven Reading (listening for incoming data) ---");
            chosenPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                @Override
                public void serialEvent(SerialPortEvent event) {
                    if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                        byte[] newData = event.getReceivedData();
                        System.out.print("Received (" + newData.length + " bytes): ");
                        for (byte b : newData) {
                            System.out.print(String.format("%02X ", b)); // Print as hex
                        }
                        System.out.println(" | " + new String(newData)); // Try to print as string
                    }
                }
            });

            // Keep the program running to receive events
            System.out.println("\nListening for data... Press Enter to close the port and exit.");
            try {
                System.in.read(); // Wait for user input to close
            } catch (IOException e) {
                System.err.println("Error reading from console: " + e.getMessage());
            }

            // 6. Close the port when done
            chosenPort.closePort();
            System.out.println("Port " + chosenPort.getSystemPortName() + " closed.");

        } else {
            System.out.println("Failed to open port " + chosenPort.getSystemPortName());
        }
    }
}

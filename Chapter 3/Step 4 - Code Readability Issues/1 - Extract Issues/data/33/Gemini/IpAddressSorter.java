import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IpAddressSorter {

    public static void main(String[] args) {
        List<String> ipAddresses = new ArrayList<>();
        ipAddresses.add("192.168.1.10");
        ipAddresses.add("10.0.0.5");
        ipAddresses.add("172.16.0.1");
        ipAddresses.add("192.168.1.2");
        ipAddresses.add("10.0.1.1");

        System.out.println("Unsorted IP Addresses:");
        for (String ip : ipAddresses) {
            System.out.println(ip);
        }

        ipAddresses.sort(new IpAddressComparator());

        System.out.println("\nSorted IP Addresses:");
        for (String ip : ipAddresses) {
            System.out.println(ip);
        }
    }

    static class IpAddressComparator implements Comparator<String> {
        @Override
        public int compare(String ip1, String ip2) {
            try {
                InetAddress address1 = InetAddress.getByName(ip1);
                InetAddress address2 = InetAddress.getByName(ip2);
                byte[] ip1Bytes = address1.getAddress();
                byte[] ip2Bytes = address2.getAddress();

                for (int i = 0; i < 4; i++) {
                    int byte1 = Byte.toUnsignedInt(ip1Bytes[i]);
                    int byte2 = Byte.toUnsignedInt(ip2Bytes[i]);
                    if (byte1 != byte2) {
                        return Integer.compare(byte1, byte2);
                    }
                }
                return 0;
            } catch (UnknownHostException e) {
                // Handle invalid IP addresses - for simplicity, consider them equal
                return 0;
            }
        }
    }
}

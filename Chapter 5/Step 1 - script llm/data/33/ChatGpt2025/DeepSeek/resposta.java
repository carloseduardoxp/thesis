import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class SortIPAddresses {
    public static void main(String[] args) {
        List<String> ipList = Arrays.asList(
            "192.168.1.5",
            "10.0.0.1",
            "172.16.0.1",
            "192.168.0.1"
        );

        ipList.sort(Comparator.comparing(SortIPAddresses::ipToLong));

        for (String ip : ipList) {
            System.out.println(ip);
        }
    }

    private static long ipToLong(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        long result = 0;
        for (String part : parts) {
            result = result << 8 | Integer.parseInt(part);
        }
        return result;
    }
}

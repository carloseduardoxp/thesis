import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IpSorter {
    public static void main(String[] args) {
        List<String> ips = Arrays.asList(
            "192.168.1.1",
            "10.0.0.1",
            "172.16.0.1",
            "192.168.1.10",
            "8.8.8.8"
        );

        List<String> sorted = ips.stream()
            .sorted(Comparator.comparing(IpSorter::ipToLong))
            .collect(Collectors.toList());

        System.out.println("Sorted IPs:");
        sorted.forEach(System.out::println);
    }

    private static long ipToLong(String ipAddress) {
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            byte[] bytes = inet.getAddress();
            long result = 0;
            for (byte b : bytes) {
                result = result << 8 | (b & 0xFF);
            }
            return result;
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("Invalid IP address: " + ipAddress, e);
        }
    }
}

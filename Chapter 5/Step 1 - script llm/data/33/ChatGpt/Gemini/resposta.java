import java.net.InetAddress;
import java.util.Arrays;
import java.util.Comparator;

public class SortIPAddresses {
    public static void main(String[] args) {
        String[] ips = {"192.168.0.2", "192.168.0.1", "10.0.0.1", "172.16.0.1"};

        Arrays.sort(ips, (ip1, ip2) -> {
            try {
                InetAddress addr1 = InetAddress.getByName(ip1);
                InetAddress addr2 = InetAddress.getByName(ip2);
                return addr1.getHostAddress().compareTo(addr2.getHostAddress());
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });

        System.out.println(Arrays.toString(ips));
    }
}

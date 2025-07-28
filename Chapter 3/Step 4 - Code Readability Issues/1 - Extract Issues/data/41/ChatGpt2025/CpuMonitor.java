import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class CpuMonitor {
    public static void main(String[] args) throws InterruptedException {
        OperatingSystemMXBean osBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        // Loop to monitor CPU usage periodically
        while (true) {
            double processCpuLoad = osBean.getProcessCpuLoad(); // 0.0 to 1.0
            System.out.printf("Process CPU Load: %.2f%%%n", processCpuLoad * 100);
            Thread.sleep(1000); // sample every 1 second
        }
    }
}

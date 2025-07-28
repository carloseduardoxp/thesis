import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class CpuMonitor {

    public static double getProcessCpuLoad() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        if (osBean != null) {
            return osBean.getProcessCpuLoad();
        } else {
            System.err.println("Warning: Unable to get detailed process CPU load on this JVM.");
            return Double.NaN;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            double cpuLoad = getProcessCpuLoad();
            if (!Double.isNaN(cpuLoad)) {
                System.out.printf("Process CPU Load: %.2f%%%n", cpuLoad * 100);
            }
            Thread.sleep(1000);
        }
    }
}

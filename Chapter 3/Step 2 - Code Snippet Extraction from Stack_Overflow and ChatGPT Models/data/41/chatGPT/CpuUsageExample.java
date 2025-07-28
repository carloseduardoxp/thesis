import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class CpuUsageExample {
    public static void main(String[] args) {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        long startCpuTime = threadBean.getCurrentThreadCpuTime();

        // Perform some CPU-intensive task
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }

        long endCpuTime = threadBean.getCurrentThreadCpuTime();
        long cpuTime = endCpuTime - startCpuTime;
        double cpuUsage = cpuTime / 1000000.0;

        System.out.println("CPU usage: " + cpuUsage + " milliseconds");
    }
}

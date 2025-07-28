import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class CPUMonitor {
    public static void main(String[] args) throws InterruptedException {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        
        // Get system load average (1 minute)
        System.out.println("System Load Average: " + osBean.getSystemLoadAverage());
        
        // For process CPU usage, we need to calculate it over time
        long prevProcessCpuTime = getProcessCpuTime();
        long prevUptime = System.nanoTime();
        
        while (true) {
            Thread.sleep(1000); // Wait 1 second
            
            long processCpuTime = getProcessCpuTime();
            long uptime = System.nanoTime();
            
            long elapsedTime = uptime - prevUptime;
            long elapsedProcessCpuTime = processCpuTime - prevProcessCpuTime;
            
            double cpuUsage = (double) elapsedProcessCpuTime / elapsedTime;
            
            System.out.printf("Process CPU Usage: %.2f%%%n", cpuUsage * 100);
            
            prevProcessCpuTime = processCpuTime;
            prevUptime = uptime;
        }
    }
    
    private static long getProcessCpuTime() {
        return ManagementFactory.getOperatingSystemMXBean().getProcessCpuTime();
    }
}

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Optional;

public class GetPidExample {
    public static void main(String[] args) {
        // Method 1 (Java 9+): Using ProcessHandle
        long currentPid = ProcessHandle.current().pid();
        System.out.println("Current Process ID (Java 9+): " + currentPid);

        // Method 2 (Java 10+): Using RuntimeMXBean.getPid()
        // This method was added in Java 10, providing a direct way
        // to get the PID from the RuntimeMXBean.
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        try {
            long pidFromMxBean = (long) RuntimeMXBean.class.getMethod("getPid").invoke(runtimeMxBean);
            System.out.println("Current Process ID (Java 10+ via RuntimeMXBean): " + pidFromMxBean);
        } catch (Exception e) {
            System.out.println("RuntimeMXBean.getPid() not available or failed: " + e.getMessage());
        }

        // Method 3 (Legacy - Works on most Java versions but less reliable)
        // This method parses the name returned by getRuntimeMXBean().getName()
        // It's not guaranteed to always contain the PID, but it commonly does
        // in the format "pid@hostname".
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        String pidString = "";
        if (jvmName.contains("@")) {
            pidString = jvmName.substring(0, jvmName.indexOf("@"));
            try {
                long legacyPid = Long.parseLong(pidString);
                System.out.println("Current Process ID (Legacy parsing): " + legacyPid);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse PID from legacy method: " + e.getMessage());
            }
        } else {
            System.out.println("Legacy method could not determine PID (format without '@' not found): " + jvmName);
        }
    }
}

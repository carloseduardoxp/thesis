import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetProcessId {
    public static void main(String[] args) {
        // Get the runtime MXBean
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        // Get the name representing the running Java virtual machine
        String jvmName = runtimeMXBean.getName();

        // Extract the PID from the name
        long pid = Long.parseLong(jvmName.split("@")[0]);

        // Print the PID
        System.out.println("Process ID: " + pid);
    }
}

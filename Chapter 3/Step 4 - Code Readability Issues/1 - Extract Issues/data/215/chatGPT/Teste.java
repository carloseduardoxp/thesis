import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a scheduler factory
            StdSchedulerFactory factory = new StdSchedulerFactory();

            // Get a scheduler from the factory
            Scheduler scheduler = factory.getScheduler();

            // Get the names of all job groups
            String[] jobGroups = scheduler.getJobGroupNames();

            // Loop through each job group
            for (String group : jobGroups) {
                // Get the keys of all jobs in the group
                for (JobKey jobKey : scheduler.getJobKeys(org.quartz.impl.matchers.GroupMatcher.jobGroupEquals(group))) {
                    // Get the job details
                    System.out.println(scheduler.getJobDetail(jobKey));
                }
            }
        } catch (SchedulerException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

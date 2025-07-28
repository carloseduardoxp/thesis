import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.List;
import java.util.Set;
import java.util.Date;

public class ListAllQuartzJobs {

    public static void main(String[] args) {
        try {
            // Get a scheduler instance (you would typically get this from your application's setup)
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            // Start the scheduler if it's not already started
            if (!scheduler.isStarted()) {
                scheduler.start();
            }

            System.out.println("--- Listing all Quartz Jobs ---");

            // Get all job group names
            List<String> jobGroupNames = scheduler.getJobGroupNames();

            if (jobGroupNames.isEmpty()) {
                System.out.println("No job groups found.");
            } else {
                for (String groupName : jobGroupNames) {
                    System.out.println("\nJob Group: " + groupName);

                    // Get all JobKeys for the current group
                    Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));

                    if (jobKeys.isEmpty()) {
                        System.out.println("  No jobs in this group.");
                    } else {
                        for (JobKey jobKey : jobKeys) {
                            String jobName = jobKey.getName();
                            String jobGroup = jobKey.getGroup();

                            System.out.println("  Job Name: " + jobName + ", Job Group: " + jobGroup);

                            // Get all triggers associated with this job
                            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);

                            if (triggers.isEmpty()) {
                                System.out.println("    No triggers associated with this job.");
                            } else {
                                for (Trigger trigger : triggers) {
                                    System.out.println("    Trigger Name: " + trigger.getKey().getName() +
                                            ", Trigger Group: " + trigger.getKey().getGroup());
                                    Date nextFireTime = trigger.getNextFireTime();
                                    if (nextFireTime != null) {
                                        System.out.println("      Next Fire Time: " + nextFireTime);
                                    } else {
                                        System.out.println("      No next fire time (possibly completed or paused).");
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // You might want to shut down the scheduler when your application exits
            // For this example, we'll keep it running briefly to show the output.
            // scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ListAllQuartzJobs {

    public static void main(String[] args) {
        try {
            // Get a scheduler instance (you would typically get this from your application's setup)
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            // Start the scheduler if it's not already started
            if (!scheduler.isStarted()) {
                scheduler.start();
            }

            listAllJobsAndTriggers(scheduler);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private static void listAllJobsAndTriggers(Scheduler scheduler) throws SchedulerException {
        System.out.println("--- Listing all Quartz Jobs ---");

        List<String> jobGroupNames = scheduler.getJobGroupNames();
        if (jobGroupNames.isEmpty()) {
            System.out.println("No job groups found.");
            return;
        }

        for (String groupName : jobGroupNames) {
            listJobsInGroup(scheduler, groupName);
        }
    }

    private static void listJobsInGroup(Scheduler scheduler, String groupName) throws SchedulerException {
        System.out.println("\nJob Group: " + groupName);

        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));
        if (jobKeys.isEmpty()) {
            System.out.println("  No jobs in this group.");
            return;
        }

        for (JobKey jobKey : jobKeys) {
            printJobAndTriggerDetails(scheduler, jobKey);
        }
    }

    private static void printJobAndTriggerDetails(Scheduler scheduler, JobKey jobKey) throws SchedulerException {
        System.out.println("  Job Name: " + jobKey.getName() + ", Job Group: " + jobKey.getGroup());

        List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
        if (triggers.isEmpty()) {
            System.out.println("    No triggers associated with this job.");
        } else {
            for (Trigger trigger : triggers) {
                printTriggerDetails(trigger);
            }
        }
    }

    private static void printTriggerDetails(Trigger trigger) {
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

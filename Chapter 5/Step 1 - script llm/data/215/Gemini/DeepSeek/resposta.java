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
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            startSchedulerIfNotRunning(scheduler);
            listAllJobs(scheduler);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private static void startSchedulerIfNotRunning(Scheduler scheduler) throws SchedulerException {
        if (!scheduler.isStarted()) {
            scheduler.start();
        }
    }

    private static void listAllJobs(Scheduler scheduler) throws SchedulerException {
        System.out.println("--- Listing all Quartz Jobs ---");
        List<String> jobGroupNames = scheduler.getJobGroupNames();

        if (jobGroupNames.isEmpty()) {
            System.out.println("No job groups found.");
            return;
        }

        for (String groupName : jobGroupNames) {
            System.out.println("\nJob Group: " + groupName);
            processJobGroup(scheduler, groupName);
        }
    }

    private static void processJobGroup(Scheduler scheduler, String groupName) throws SchedulerException {
        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));

        if (jobKeys.isEmpty()) {
            System.out.println("  No jobs in this group.");
            return;
        }

        for (JobKey jobKey : jobKeys) {
            processJob(scheduler, jobKey);
        }
    }

    private static void processJob(Scheduler scheduler, JobKey jobKey) throws SchedulerException {
        String jobName = jobKey.getName();
        String jobGroup = jobKey.getGroup();
        System.out.println("  Job Name: " + jobName + ", Job Group: " + jobGroup);

        List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
        if (triggers.isEmpty()) {
            System.out.println("    No triggers associated with this job.");
            return;
        }

        for (Trigger trigger : triggers) {
            processTrigger(trigger);
        }
    }

    private static void processTrigger(Trigger trigger) {
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

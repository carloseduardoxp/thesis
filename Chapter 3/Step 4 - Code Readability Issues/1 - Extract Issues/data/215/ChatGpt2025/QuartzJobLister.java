import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import java.util.List;
import java.util.Set;

public class QuartzJobLister {

    public static void listAllJobs(Scheduler scheduler) {
        try {
            // Get all job group names
            List<String> jobGroups = scheduler.getJobGroupNames();

            for (String group : jobGroups) {
                // Get all jobs in the group
                Set<JobKey> jobKeys = scheduler.getJobKeys(org.quartz.impl.matchers.GroupMatcher.jobGroupEquals(group));

                for (JobKey jobKey : jobKeys) {
                    // You can get JobDetail if needed:
                    // JobDetail jobDetail = scheduler.getJobDetail(jobKey);

                    System.out.println("Job found: " + jobKey.getName() + " in group: " + jobKey.getGroup());
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
